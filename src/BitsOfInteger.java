public class BitsOfInteger{

    public static int reverseBits(int decimal){
        String binary = "";
        while (decimal > 0) {
            if ((decimal % 2) == 0) {
                binary += "0";
            } else {
                binary += "1";
            }
            decimal /= 2;
        }
        return binaryToDecimal(binary);
    }

    public static int binaryToDecimal(String binary){
        int decimal = 0;
        for (int i = binary.length()-1; i >= 0; i--){
            if (binary.charAt(i) == '1') {
                decimal += (int) Math.pow(2.0, (double)((binary.length() - 1) - i));
            }
        }
        return decimal;
    }

}