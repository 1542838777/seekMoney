package com.example.seekmoney;

import com.example.seekmoney.service.SeckillService;
import com.example.seekmoney.service.user.LoginService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



@SpringBootTest
class SeekMoneyApplicationTests {
		private static final String TEST_S = "{\n" +
				"    \"code\": 1,\n" +
				"    \"msg\": \"ok\",\n" +
				"    \"time\": \"1731564021\",\n" +
				"    \"data\": {\n" +
				"        \"total\": 33,\n" +
				"        \"per_page\": 33,\n" +
				"        \"current_page\": 1,\n" +
				"        \"last_page\": 1,\n" +
				"        \"data\": [\n" +
				"            {\n" +
				"                \"id\": 1288,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1685853027,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564046,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 24\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1289,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1685853027,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564059,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 37\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1290,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1685853027,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564033,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 11\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1362,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498555,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564051,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 29\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1363,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498555,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564044,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 22\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1364,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498555,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564050,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 28\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1371,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498662,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564026,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 4\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1372,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498662,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564024,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 2\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1373,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498662,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564025,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 3\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1380,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498720,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564036,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 14\n" +
				"            },\n" +
				"{\n" +
				"                \"id\": 1381,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498720,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564019,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -19\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1382,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1687498720,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564017,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -21\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1464,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564027,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -11\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1465,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564010,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -28\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1466,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564059,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 21\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1467,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564057,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 19\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1468,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564018,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -20\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1469,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564048,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 10\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1470,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564050,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 12\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1471,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564042,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 4\n" +
				"            },{\n" +
				"                \"id\": 1472,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564038,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -4\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1473,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564052,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 10\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1474,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564042,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 0\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1475,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564058,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": 16\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1476,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564011,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -31\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1477,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564028,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -14\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1478,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564015,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -27\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1479,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564026,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -16\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1480,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564033,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                },\n" +
				"                \"status_text\": \"Status 0\",\n" +
				"                \"djs\": -9\n" +
				"            },\n" +
				"            {\n" +
				"                \"id\": 1481,\n" +
				"                \"goods_id\": 841,\n" +
				"                \"goods_title\": \"秒杀商品-ZS-Seckill merchandise\",\n" +
				"                \"goods_image\": \"https:\\/\\/jjl24.oss-cn-beijing.aliyuncs.com\\/uploads\\/20221010\\/241e4e43d3256aba61e48382c06b2691.png\",\n" +
				"                \"seckill_config_id\": 2,\n" +
				"                \"price\": \"1000.00\",\n" +
				"                \"status\": 0,\n" +
				"                \"createtime\": 1693378323,\n" +
				"                \"remark\": \"\",\n" +
				"                \"group_id\": 1,\n" +
				"                \"start_time\": 1731564042,\n" +
				"                \"income_rate\": \"1.20\",\n" +
				"                \"group_income_rate\": \"1.20\",\n" +
				"                \"seckillconfig\": {\n" +
				"                    \"id\": 2,\n" +
				"                    \"name\": \"会员区\",\n" +
				"                    \"seckill_times\": 30000,\n" +
				"                    \"start_time\": \"14:00:00\",\n" +
				"                    \"end_time\": \"14:10:00\",\n" +
				"                    \"status\": 1,\n" +
				"                    \"createtime\": 1672747790,\n" +
				"                    \"updatetime\": 1731557998,\n" +
				"                    \"seckill_ensure\": 0,\n" +
				"                    \"status_text\": \"Status 1\"\n" +
				"                }\n" +
				"}\n" +
				"        ]\n" +
				"    }\n" +
				"}";
	@Autowired
	SeckillService service;


	@Test
	void contextLoads() {
		System.out.println("执行fromTest");
		service.exceed();
//		service.sortAndSeekv2(null, null);
		System.out.printf("list>>>");
	}
	@Resource
	LoginService loginService;
	private Object getSubTime() {
		return null;
	}



	private Long mockCurrentMillis() {
		return 1731564010000L-3000L;
	}


	private void 测试多并发调用sleep的问题() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 5; i++) {
			executorService.submit(() -> {
				m1();
			});
		}
	}

	@SneakyThrows
	private void m1() {
		//睡眠一秒执行
		Thread.sleep(1000L);
		//xxxx逻辑执行
	}

}
