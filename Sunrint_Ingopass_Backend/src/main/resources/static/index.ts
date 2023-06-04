import { Body, Controller, Get, Post, Query, UseGuards } from '@nestjs/common';
import {
    ApiParam,
    ApiTags,
    ApiCreatedResponse,
    ApiOperation,
    ApiBody,
    ApiOkResponse,
    ApiBearerAuth,
} from '@nestjs/swagger';
import { JwtAuthGuard } from 'src/auth/guard/jwt-auth.guard';
import { PrivilegedGuard } from 'src/auth/guard/privileged-auth.guard';
import { BasicService } from './basic.service';
import { CreateNoticeDto } from './dto/create-notice.dto';
import { Notice } from './schema/notice.schema';

@Controller('basic') // 라우드 basic 개설
@ApiTags('Basic') // Swagger에 전달할 라벨
export class BasicController {
    constructor(private readonly basicService: BasicService) {}

    @Get('meal') // GET basic/meal
    @ApiBearerAuth() // Swagger에 Bearer 토큰이 필요한 API임을 알려줌
    @UseGuards(JwtAuthGuard) // 커스텀JWTStrategy(JWTAuthGuard)를 통해 인증되지 않으면 막음
    @ApiOperation({ // Swagger에 전달할 설명
        summary: '급식 정보',
        description:
            '해당 날짜의 급식을 불러옵니다. 값이 없으면 오늘의 급식을 불러옵니다.',
    })
    @ApiParam({ // Swagger에 전달할, api의 인자에 대한 정보
        type: 'string',
        name: 'date',
        description: '급식을 불러올 날짜',
        example: '20220923',
    })
    @ApiCreatedResponse({ // Swagger에 전달할, api의 응답에 대한 정보
        description: '급식 정보',
        schema: {
            example: {
                data: [
                    '콩나물밥/부추양념장',
                    '우렁된장찌개',
                    '비건함박구이',
                    '총각김치',
                    '쥬시쿨',
                    '파스타샐러드',
                ],
            },
        },
    })
    async getMeal(@Query('date') date: string): Promise<object> { // GET basic/meal?date={날짜:string}
        if (!date) {
            date = new Date().toJSON().slice(0, 10).replace(/-/g, '');
        }
        return this.basicService.findMeal(date);
    }