import java.util.ArrayList;
import java.util.Scanner;

public class Day02 extends AocDay{

    @Override
    public String solvePart1(String inputFile) throws Exception {
        Scanner s = getScanner(inputFile);
        ArrayList<Round> rounds = new ArrayList<>();
        while (s.hasNext()) {
            String round = s.nextLine();
//            System.out.println(round);
            rounds.add(new Round(round));
        }

        return "" + rounds.stream().reduce(0,(subtotal,round) -> subtotal + round.getRoundTotal(), Integer::sum);
    }

    @Override
    public String solvePart2(String inputFile) throws Exception {
        Scanner s = getScanner(inputFile);
        ArrayList<Round> rounds = new ArrayList<>();
        while (s.hasNext()) {
            String round = s.nextLine();
            rounds.add(new Round(round.charAt(0),round.charAt(2)));
        }
        return "" + rounds.stream().reduce(0,(subtotal,round) -> subtotal + round.getRoundTotal(), Integer::sum);
    }

    private class Round{
        Move myThrow;
        Move opponentThrow;
        Outcome outcome;

        Round(String round) {
            opponentThrow = getThrow(round.charAt(0));
            myThrow = getThrow(round.charAt(2));
            outcome = evalOutcome(myThrow,opponentThrow);
        }

        Round(char opponentMove, char outcome) {
            this.opponentThrow = getThrow(opponentMove);
            this.outcome = setOutcome(outcome);
            this.myThrow = findMove(this.opponentThrow,this.outcome);
        }

        Move getThrow(char val) {
            switch (val) {
                case 'A':
                case 'X':
                    return Move.ROCK;
                case 'B':
                case 'Y':
                    return Move.PAPER;
                case 'C':
                case 'Z':
                    return Move.SCISSORS;
            }
            return Move.ROCK;
        }

        Outcome setOutcome(char outcome){
            switch (outcome) {
                case 'X': return Outcome.LOSE;
                case 'Y': return Outcome.TIE;
                default: return Outcome.WIN;
            }
        }

        Move findMove(Move move, Outcome desiredOutcome) {

            if (desiredOutcome == Outcome.WIN) {
                switch (move) {
                    case ROCK: return Move.PAPER;
                    case PAPER: return Move.SCISSORS;
                    case SCISSORS: return Move.ROCK;
                }
            } else if(desiredOutcome == Outcome.LOSE) {
                switch (move) {
                    case ROCK: return Move.SCISSORS;
                    case PAPER: return Move.ROCK;
                    case SCISSORS: return Move.PAPER;
                }
            }

            return move;
        }

        Outcome evalOutcome(Move myThrow, Move opponentThrow) {
            if (myThrow == opponentThrow)
                return Outcome.TIE;

            if ((myThrow == Move.ROCK && opponentThrow == Move.SCISSORS)
                || (myThrow == Move.PAPER && opponentThrow == Move.ROCK)
                || (myThrow == Move.SCISSORS && opponentThrow == Move.PAPER))
                return Outcome.WIN;

            return Outcome.LOSE;
        }

        public int getRoundTotal() {
            return outcome.getScore() + myThrow.getScore();
        }
    }

    private enum Move {
        ROCK(1),PAPER(2),SCISSORS(3);
        final int score;
        Move(int score) {
            this.score = score;
        }

        public int getScore(){
            return score;
        }
    }

    private enum Outcome {
        WIN(6),TIE(3),LOSE(0);
        final int score;
        Outcome(int score) {
            this.score = score;
        }

        public int getScore(){
            return score;
        }
    }
}
