package tool.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IpToInt {

    protected static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {


        //https://mp.weixin.qq.com/s/FzAMbks0PUorZFsCFw7KTg


        String[] ips4Test = new String[]{"0.0.0.0", "127.0.0.1",
                "192.168.1.1", "255.0.0.255", "255.255.255.255"};
        for (String ip : ips4Test) {
            test(ip);
        }

        logger.info("3 = {}", Long.toBinaryString(-3));
        logger.info("13 = {}", Long.toBinaryString(13));
        logger.info("354 = {}", Long.toBinaryString(354));
        logger.info("3258 = {}", Long.toBinaryString(3258));
        logger.info("45103 = {}", Long.toBinaryString(45103));
        logger.info("123453 = {}", Long.toBinaryString(123453));
        logger.info("1478523 = {}", Long.toBinaryString(1478523));
        logger.info("1343543252 = {}", Long.toBinaryString(-2143543252));


        test("127.236.41.1");

    }


    public static void test(String ip) {
        int ipInt = ip2Int(ip);
        String ipString = int2Ip(ipInt);
        System.out.println("用于测试的ip地址: " + ip + ", int表示: " + ipInt + ", 二进制: " + Long.toBinaryString(ipInt)
                + ", 转回String: " + ipString + "，与测试 ip 地址是否相等: " + ip.equals(ipString));
    }


    /**
     * 将 ip 字符串转换为 int 类型的数字
     * <p>
     * 思路就是将 ip 的每一段数字转为 8 位二进制数，并将它们放在结果的适当位置上
     *
     * @param ipString ip字符串，如 127.0.0.1
     * @return ip字符串对应的 int 值
     */
    public static int ip2Int(String ipString) {
        // 取 ip 的各段
        String[] ipSlices = ipString.split("\\.");
        int rs = 0;

        int dedicateResult = 0;

        for (int i = 0; i < ipSlices.length; i++) {

            Integer integerSlice = Integer.parseInt(ipSlices[i]);

            int afterMove = integerSlice << 8 * i;

            dedicateResult = dedicateResult | afterMove;

            // 将 ip 的每一段解析为 int，并根据位置左移 8 位
            int intSlice = Integer.parseInt(ipSlices[i]) << 8 * i;
            // 求与
            rs = rs | intSlice;
        }
        return rs;
    }





    /**
     * 将 int 转换为 ip 字符串
     *
     * @param ipInt 用 int 表示的 ip 值
     * @return ip字符串，如 127.0.0.1
     */
    public static String int2Ip(int ipInt) {
        String[] ipString = new String[4];

        logger.info("ipInt = {}", ipInt);

        for (int i = 0; i < 4; i++) {
            // 每 8 位为一段，这里取当前要处理的最高位的位置
            int pos = i * 8;

            logger.info("pos = {}", pos);

            logger.info("255 << {} = {}", pos,255 << pos);

            logger.info("and = ipInt & (255 << pos) = {} & {} = {}", ipInt, 255 << pos,ipInt & (255 << pos));

            // 取当前处理的 ip 段的值
            int and = ipInt & (255 << pos);
            // 将当前 ip 段转换为 0 ~ 255 的数字，注意这里必须使用无符号右移

            logger.info("and >>> pos = {} >>> {} = {}", and, pos, and >>> pos);

            ipString[i] = String.valueOf(and >>> pos);


            logger.info("===========================================>");

        }
        return String.join(".", ipString);
    }
}
