package org.ngandois.gcd.MMXVI.university.practice;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.Exercise;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.ReadNbLineFirstCaseReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Practice Round APAC test 2016: too slow but do the job :(
public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        //new ExerciseResolver("A-small-practice-1", solver).resolve();
        new ExerciseResolver("A-small-practice-2", solver).resolve();
    }

    public A() {
        super(new ReadNbLineFirstCaseReader(new InputSpaceParsing()));
    }

    @Override
    public Exercise.TestResult apply(Exercise.TestCase aCase) {
        Deque<Possibility> possibilities = new LinkedList<>();

        // init
        ArrayList<String> line = aCase.data.get(0);
        List<String> g1 = new LinkedList<>();
        g1.add(line.get(0));
        List<String> g2 = new LinkedList<>();
        g2.add(line.get(1));
        possibilities.offer(new Possibility(g1, g2, 1));

        boolean ok;
        do {
            ok = test(aCase, possibilities.pollLast(), possibilities);
        } while (!ok && !possibilities.isEmpty());


        return new Exercise.TestResult(aCase.testNumber, ok ? "Yes" : "No");

    }

    private boolean test(Exercise.TestCase aCase, Possibility possibility, Deque<Possibility> possibilities) {
        for (int i = possibility.nextIndex; i < aCase.data.size(); i++) {
            ArrayList<String> line = aCase.data.get(i);

            String n1 = line.get(0);
            String n2 = line.get(1);

            byte c = 0; // 0
            c |= possibility.group1.contains(n1) ? 0b1000 : 0; // 8
            c |= possibility.group2.contains(n1) ? 0b0100 : 0; // 4
            c |= possibility.group1.contains(n2) ? 0b0010 : 0; // 2
            c |= possibility.group2.contains(n2) ? 0b0001 : 0; // 1

            switch (c) {
                case 0:
                    // two possibilities
                    //  - take one
                    //  - record the other one
                    possibilities.offer(possibility.clone(i + 1, n1, n2));

                    possibility.group1.add(n2);
                    possibility.group2.add(n1);
                    break;
                case 1:
                    possibility.group1.add(n1);
                    break;
                case 2:
                    possibility.group2.add(n1);
                    break;
                case 4:
                    possibility.group1.add(n2);
                    break;
                case 5:
                    return false;
                case 6:
                    break; // already dispatched
                case 8:
                    possibility.group2.add(n2);
                    break;
                case 9:
                    break; // already dispatched
                case 10:
                    return false;
                default:
                    throw new RuntimeException("not managed: " + c);

            }
        }
        return true; //dispatched all
    }


    private static class Possibility {
        final List<String> group1;
        final List<String> group2;
        final int nextIndex;

        private Possibility(List<String> group1, List<String> group2, int nextIndex) {
            this.group1 = group1;
            this.group2 = group2;
            this.nextIndex = nextIndex;
        }

        private Possibility clone(int nextIndex, String nG1, String nG2) {
            List<String> group1 = new LinkedList<>(this.group1);
            group1.add(nG1);

            List<String> group2 = new LinkedList<>(this.group2);
            group2.add(nG2);

            return new Possibility(group1, group2, nextIndex);
        }
    }
}
