package Trabalho01;

import java.io.File;
import java.util.Scanner;

public class JungleGame {
    int rounds;
    Monkey[] monkeys;

    public JungleGame(String filePath) {
        File file = new File(filePath);
        int lineAmount = FileHelper.countLines(file);
        this.monkeys = new Monkey[lineAmount - 1];
        analyseFile(file);
    }

    private void analyseFile(File file) {
        Scanner fileReader = FileHelper.fileScanner(file);
        this.rounds = Integer.parseInt(fileReader.nextLine().split(" ")[1]);
        
        for (int i = 0; fileReader.hasNextLine(); i++) {
            String line = fileReader.nextLine();
            /* line = Macaco {id} par -> {evenTarget} impar -> {oddTarget} : {coconutAmount} : {stoneAmount} {stoneAmount} {stoneAmount} */

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
            int evenTarget = Integer.parseInt(target[1].substring(0, 1));
            int oddTarget = Integer.parseInt(target[2].substring(0, 1));

            int coconutsAmount = Integer.parseInt(partial[1]);
            Coconut[] coconuts = new Coconut[coconutsAmount];

            String[] stonesString = partial[2].split(" ");
            for (int j = 0; j < coconutsAmount; j++) {
                int stoneAmount = Integer.parseInt(stonesString[j]);
                coconuts[j] = new Coconut(stoneAmount);
            }

            this.monkeys[i] = new Monkey(i, evenTarget, oddTarget, coconuts);
        }

        fileReader.close();
    }
}
