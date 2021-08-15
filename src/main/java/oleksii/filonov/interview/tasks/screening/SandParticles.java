package oleksii.filonov.interview.tasks.screening;

import java.util.ArrayList;
import java.util.List;

public class SandParticles {
    static String[] INPUT = {
            "| . . . . |",
            "| ##  #   |",
            "|   # ##  |",
            "|         |",
            "-----------"
    };

    // . - particle, ' ' - free to move, anything else - obsticle
    // iterate() {
    // print the state

    private static class MovingParticles {

        private final char [][] state;

        private final char PARTICLE = '.';
        private final char SPACE = ' ';

        private final List<int []> particles;

        public MovingParticles(String[] input) {

            this.state = new char [input.length][input[0].length()];
            particles = new ArrayList<>();

            for(int i = 0; i < input.length; i++) {
                for(int j = 0; j < input[0].length(); j++) {
                    char symbol = input[i].charAt(j);
                    this.state[i][j] = symbol;
                    if(symbol == PARTICLE)
                        particles.add(new int [] {i, j});
                }
            }

        }

        public void iterate() {
            for(int [] particle: particles) {
                //row - [0], column - [1]
                //down
                if(state[particle[0] + 1][particle[1]] == SPACE) {
                    state[particle[0]][particle[1]] = SPACE;
                    particle[0] += 1;
                    state[particle[0]][particle[1]] = PARTICLE;
                } else {
                    if(Math.random() > 0.5) {
                        //right
                        if(state[particle[0]][particle[1] + 1] == SPACE) {
                            state[particle[0]][particle[1]] = SPACE;
                            particle[1]++;
                            state[particle[0]][particle[1]] = PARTICLE;
                        }
                        else if(state[particle[0]][particle[1] - 1] == SPACE) {
                            state[particle[0]][particle[1]] = SPACE;
                            particle[1]--;
                            state[particle[0]][particle[1]] = PARTICLE;
                        }
                    } else {
                        if(state[particle[0]][particle[1] - 1] == SPACE) {
                            state[particle[0]][particle[1]] = SPACE;
                            particle[1]--;
                            state[particle[0]][particle[1]] = PARTICLE;
                        }
                        else if(state[particle[0]][particle[1] + 1] == SPACE) {
                            state[particle[0]][particle[1]] = SPACE;
                            particle[1]++;
                            state[particle[0]][particle[1]] = PARTICLE;
                        }
                    }
                }
            }
            printState();
        }


        private void printState() {
            for (char[] row : state) {
                System.out.println(new String(row));
            }
        }


    }


    public static void main(String[] args) {
        MovingParticles particles = new MovingParticles(INPUT);
        particles.iterate();
        particles.iterate();
        particles.iterate();
    }
}
