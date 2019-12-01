package valid_ip_address;
/* https://leetcode-cn.com/problems/validate-ip-address/submissions/ */
public class ValidIPAddress {

    public static void main(String[] args) {

        String result= validIPAddress("2001:0db8:85a3:0000:0:8A2E:0370:733a");
        boolean b= "85a3".toLowerCase().matches("((?=.*\\d)(?!.*[g-z]).{1,4})");
        boolean c= "0000".startsWith("00");
        System.out.println(c);

        String[] str= "2001:0db8:85a3:0:0:8A2E:0370:7334:".split(":");
        for (String s: str)
        System.out.println(s);

        String result2= validIPAddress("1.1.2.1.");
        System.out.println(result2.lastIndexOf("2"));
        String ss= "1.1.2.1.";
        System.out.println(ss.charAt(ss.length()-1));
        System.out.println(result2);
    }

    public static String validIPAddress(String IP) {

        if (4== IP.split("\\.").length){  //IPv4
            if(IP.charAt(IP.length()-1)=='.')
                return "Neither";
            String[] str= IP.split("\\.");
            for(String subStr : str){
                if(subStr.trim().equals("") || (subStr.length()!=1 && subStr.startsWith("0")) || !subStr.toLowerCase().matches("((?=.*\\d)(?!.*\\W)(?!.*[a-z]).{1,3})") || Integer.parseInt(subStr)> 255)
                    return "Neither";
            }
            return "IPv4";
        }else if(8== IP.split(":").length){ //IPv6
            if(IP.charAt(IP.length()-1)==':')
                return "Neither";
            String[] str= IP.split(":");
            for(String subStr : str){
                if(subStr.trim().equals("") || subStr.startsWith("00") || !subStr.toLowerCase().matches("((?!.*\\W)(?!.*[g-z]).{1,4})") || Long.parseLong(subStr, 16)> 65535)
                return "Neither";
                //正则表达式不能出现某字符 (?!.*[g-z])
            }
            return "IPv6";
        }
        else return "Neither";
    }
}
