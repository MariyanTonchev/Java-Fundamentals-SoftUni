import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        for (int i = 1; i<=length; i++){
            int digit = input.charAt(0) - 48;
            switch (digit){
                case 2:
                    if(input.length() == 1){
                        text.append("a");
                    } else if (input.length() == 2){
                        text.append("b");
                    } else if (input.length() == 3){
                        text.append("c");
                    }
                    break;
                case 3:
                    if(input.length() == 1){
                        text.append("d");
                    } else if (input.length() == 2){
                        text.append("e");
                    } else if (input.length() == 3){
                        text.append("f");
                    }
                    break;
                case 4:
                    if(input.length() == 1){
                        text.append("g");
                    } else if (input.length() == 2){
                        text.append("h");
                    } else if (input.length() == 3){
                        text.append("i");
                    }
                    break;
                case 5:
                    if(input.length() == 1){
                        text.append("j");
                    } else if (input.length() == 2){
                        text.append("k");
                    } else if (input.length() == 3){
                        text.append("l");
                    }
                    break;
                case 6:
                    if(input.length() == 1){
                        text.append("m");
                    } else if (input.length() == 2){
                        text.append("n");
                    } else if (input.length() == 3){
                        text.append("o");
                    }
                    break;
                case 7:
                    if(input.length() == 1){
                        text.append("p");
                    } else if (input.length() == 2){
                        text.append("q");
                    } else if (input.length() == 3){
                        text.append("r");
                    } else if (input.length() == 4){
                        text.append("s");
                    }
                    break;
                case 8:
                    if(input.length() == 1){
                        text.append("t");
                    } else if (input.length() == 2){
                        text.append("u");
                    } else if (input.length() == 3){
                        text.append("v");
                    }
                    break;
                case 9:
                    if(input.length() == 1){
                        text.append("w");
                    } else if (input.length() == 2){
                        text.append("x");
                    } else if (input.length() == 3){
                        text.append("y");
                    } else if (input.length() == 4){
                        text.append("z");
                    }
                    break;
                case 0:
                    text.append(" ");
                    break;
            }
            if(i < length) {
                input = scanner.nextLine();
            }
        }
        System.out.println(text);
    }
}
