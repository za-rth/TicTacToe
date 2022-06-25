import java.util.*;
import java.lang.reflect.Array;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String [] args) {
        char[][] gameboard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameboard(gameboard);
        Scanner scan = new Scanner(System.in);

                while (true){
                        System.out.println("Enter your placement (1-9) below");
                        int playerPos = scan.nextInt();
                        while (playerPositions.contains(playerPos)|| cpuPositions.contains(playerPositions)){
                            System.out.println("Position Taken!, Try again");
                                playerPos = scan.nextInt();
                        }
                        placePiece(gameboard, playerPos, "Player");
                            String result = checkWinner();
                    if(result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
                        Random rand = new Random();
                        int cpuPos = rand.nextInt(9 + 1);
                        while (playerPositions.contains(cpuPos)|| playerPositions.contains(cpuPos)){

                            cpuPos = rand.nextInt(9 + 1);
                            System.out.println(playerPos);
                    }
                        placePiece(gameboard, cpuPos, "CPU");
                        printGameboard(gameboard);
                            result = checkWinner();
                            if(result.length() > 0) {
                                System.out.println(result);
                                break;
                            }
            }
        }

        public static String checkWinner(){

            List topRow = Arrays.asList(1,2,3);
            List midRow = Arrays.asList(4,5,6);
            List botRow = Arrays.asList(7,8,9);
            List leftCol = Arrays.asList(1,4,7);
            List midCol = Arrays.asList(2,5,8);
            List rightCol = Arrays.asList(3,6,9);
            List cross1 = Arrays.asList(1,5,9);
            List cross2 = Arrays.asList(3,5,7);

           List<List> winningConditions = new ArrayList<List>();
                winningConditions.add(topRow);
                winningConditions.add(midRow);
                winningConditions.add(botRow);
                winningConditions.add(leftCol);
                winningConditions.add(midCol);
                winningConditions.add(rightCol);
                winningConditions.add(cross1);
                winningConditions.add(cross2);

            for (List l : winningConditions) {
                if (playerPositions.containsAll(l)) {
                    return "Congrats you have won!";
                }
                else if (cpuPositions.containsAll(l)){
                    return "CPU have won";
                } else if (playerPositions.size() + cpuPositions.size() == 9) {
                    return "CAT";


                }
            }
                
            return "";


        }

    public static void printGameboard(char[][] gameboard) {
        for (char[] row : gameboard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char [] [] gameboard, int pos, String user){
        char symbol = ' ';
        if(user.equals("Player")) {
            symbol = 'X';
            playerPositions.add(pos);
        }
        else if(user.equals("CPU")){
            symbol = 'O';
            cpuPositions.add(pos);
        }




        switch (pos){
            case 1:
                gameboard[0][0] = symbol;
                break;
            case 2:
                gameboard[0][2] = symbol;
                break;
            case 3:
                gameboard[0][4] = symbol;
                break;
            case 4:
                gameboard[2][0] = symbol;
                break;
            case 5:
                gameboard[2][2] = symbol;
                break;
            case 6:
                gameboard[2][4] = symbol;
                break;
            case 7:
                gameboard[4][0] = symbol;
                break;
            case 8:
                gameboard[4][2] = symbol;
                break;
            case 9:
                gameboard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
}

