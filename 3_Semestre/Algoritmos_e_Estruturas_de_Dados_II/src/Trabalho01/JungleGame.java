package Trabalho01;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class JungleGame {
    int rounds;
    Monkey[] monkeys;

    public JungleGame(File file) {
        int lineAmount = FileHelper.countLines(file);
        if (lineAmount <= 1)
            throw new IllegalArgumentException("Arquivo inválido ou vazio.");
        this.monkeys = new Monkey[lineAmount - 1];
        analyseFile(file);
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            // System.out.println("\n\n===== ROUND " + i + " =====\n");

            for (int j = 0; j < monkeys.length; j++) {
                Monkey monkey = monkeys[j];
                // System.out.println(monkey.toString().substring(0, 8) + " " + monkey.getCoconuts().size() + " - cocos.");
                Monkey evenTarget = monkeys[monkey.getEvenTarget()];
                Monkey oddTarget = monkeys[monkey.getOddTarget()];
                monkey.throwCoconuts(evenTarget, oddTarget);
            }
        }

        Stream<Monkey> monkeyStream = Arrays.asList(monkeys).stream();
        List<Monkey> monkeysResult = monkeyStream
                .sorted((monkeyA, monkeyB) -> monkeyA.getCoconuts().size() < monkeyB.getCoconuts().size() ? 1 : -1)
                .toList();

        System.out.println("========== RESULTADOS ==========");
        for (int i = 1; i <= monkeysResult.size(); i++) {
            Monkey monkey = monkeysResult.get(i - 1);
            String[] monkeyString = monkey.toString().split(" ");
            String monkeyName = monkeyString[0];
            String monkeyNumber = monkeyString[1];
            String monkeyId = monkeyName + " " + monkeyNumber;
            System.out.println(i + "º lugar: " + monkeyId + " - " + monkey.getCoconuts().size() + " cocos.");
        }
        System.out.println("================================");
    }

    private void analyseFile(File file) {
        Scanner fileReader = FileHelper.fileScanner(file);
        this.rounds = Integer.parseInt(fileReader.nextLine().split(" ")[1]);

        for (int i = 0; fileReader.hasNextLine(); i++) {
            String line = fileReader.nextLine();
            // line = Macaco {id} par -> {evenTarget} impar -> {oddTarget} : {coconutAmount} : {stoneAmount} {stoneAmount} {stoneAmount}

            String[] partial = line.split(" : ");
            /* partial = [
                Macaco {id} par -> {evenTarget} impar -> {oddTarget}
                { coconutAmount }
                {stoneAmount} {stoneAmount} {stoneAmount}
            ]*/

            String[] target = partial[0].split(" -> ");
            /* target = [
                Macaco {id} par
                {evenTarget} impar
                {oddTarget}
            ]*/
            int evenTarget = Integer.parseInt(target[1].split(" ")[0]);
            int oddTarget = Integer.parseInt(target[2]);

            int coconutsAmount = Integer.parseInt(partial[1]);
            ArrayList<Coconut> coconuts = new ArrayList<Coconut>(coconutsAmount);

            String[] stonesString = partial[2].split(" ");
            for (int j = 0; j < coconutsAmount; j++) {
                int stoneAmount = Integer.parseInt(stonesString[j]);
                coconuts.add(new Coconut(stoneAmount));
            }

            this.monkeys[i] = new Monkey(i, evenTarget, oddTarget, coconuts);
        }

        fileReader.close();
    }
}
