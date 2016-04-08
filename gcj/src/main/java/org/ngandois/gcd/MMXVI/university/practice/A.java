package org.ngandois.gcd.MMXVI.university.practice;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.*;


public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        new ExerciseResolver("A-small-practice-1", solver).resolve();

        // MUST not try to create all possibilities
        // BUT must try a solution and if fail try another one until no more possible solution
        //new ExerciseResolver("A-small-practice-2", solver).resolve();
    }

    public A() {
        super(new ReadNbLineFirstCaseReader(new InputSpaceParsing()));
    }

    @Override
    public Exercise.TestResult apply(Exercise.TestCase aCase) {

        Collection<Map.Entry<Collection<String>, Collection<String>>> possibleGroups = new LinkedList<>();
        for (ArrayList<String> d : aCase.data) {
            if (possibleGroups.isEmpty()) {
                possibleGroups.add(init(d));
            } else {
                String p1 = d.get(0);
                String p2 = d.get(1);

                Collection<Map.Entry<Collection<String>, Collection<String>>> newPossibleGroups = new LinkedList<>();
                Iterator<Map.Entry<Collection<String>, Collection<String>>> it = possibleGroups.iterator();
                while (it.hasNext()) {
                    Map.Entry<Collection<String>, Collection<String>> pairs = it.next();
                    Collection<String> g1 = pairs.getKey();
                    Collection<String> g2 = pairs.getValue();

                    byte c = 0;
                    c |= g1.contains(p1) ? 0b1000 : 0;
                    c |= g2.contains(p1) ? 0b0100 : 0;
                    c |= g1.contains(p2) ? 0b0010 : 0;
                    c |= g2.contains(p2) ? 0b0001 : 0;

                    switch (c) {
                        case 0:
                            newPossibleGroups.add(duplicatePair(pairs, d));
                            break;
                        case 1:
                            g1.add(p1);
                            break;
                        case 2:
                            g2.add(p1);
                            break;
                        case 4:
                            g1.add(p2);
                            break;
                        case 5:
                            it.remove();
                            break;
                        case 8:
                            g2.add(p2);
                            break;
                        case 10:
                            it.remove();
                            break;
                        default:
                            new Exercise.TestResult(aCase.testNumber, "ERROR");

                    }
                }

                possibleGroups.addAll(newPossibleGroups);
            }
            if (possibleGroups.isEmpty()) { //removed the last group, no more possibility
                break;
            }
        }

        return new Exercise.TestResult(aCase.testNumber, possibleGroups.isEmpty() ? "No" : "Yes");

    }

    private Map.Entry<Collection<String>, Collection<String>> init(ArrayList<String> d) {
        Collection<String> g1 = new HashSet<>();
        g1.add(d.get(0));
        Collection<String> g2 = new HashSet<>();
        g2.add(d.get(1));

        return new HashMap.SimpleEntry<>(g1, g2);
    }


    private Map.Entry<Collection<String>, Collection<String>> duplicatePair(Map.Entry<Collection<String>, Collection<String>> pairs, ArrayList<String> d) {
        String p1 = d.get(0);
        String p2 = d.get(1);

        Map.Entry<Collection<String>, Collection<String>> duplicated = new HashMap.SimpleEntry<>(new HashSet<>(pairs.getKey()), new HashSet<>(pairs.getValue()));

        pairs.getKey().add(p1);
        pairs.getValue().add(p2);

        duplicated.getKey().add(p2);
        duplicated.getValue().add(p1);

        return duplicated;
    }

}
