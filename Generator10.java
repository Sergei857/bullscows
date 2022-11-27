package bullscows;


public class Generator10 {


    static StringBuilder alfabet_code = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");


    static String randomgen(Integer dlina, Integer numbers) {
        StringBuilder code = new StringBuilder("");

        while (code.length() != dlina) {
            int poz = (int) (Math.random() * numbers);
            if (!code.toString().contains(String.valueOf(alfabet_code.charAt(poz)))) {
                code.append(alfabet_code.charAt(poz));
            }
        }
        return code.toString();
    }
}