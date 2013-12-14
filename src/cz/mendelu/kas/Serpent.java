/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.kas;

import java.util.Arrays;

/**
 *
 * @author Jan Kyselica <kyselica.jan@gmail.com>
 */
public class Serpent {

    public byte[] encode(byte[] data) {
        int countOfBlock = (int) Math.ceil(data.length / 16);
        byte[] encoding = new byte[data.length];
        Arrays.fill(encoding, (byte) 8);

        byte[][] tempr = new byte[4][4];
        System.out.println("Pocet blokov: " + countOfBlock);
        for (int i = 0; i < countOfBlock; i++) {
            byte[] temp = Arrays.copyOfRange(data, i * 16, 16 * (i + 1));
            for (int j = 0; j < 4; j++) {
                tempr[j] = Arrays.copyOfRange(temp, j * 4, 4 * (j + 1));
            }
            byte[] tmp;
            for (int round = 0; round < 32; round++) {
                tmp = Arrays.copyOf(tempr[0], 4);
            }
            for (int j = 0; j < 4; j++) {
                int o = 1;
                System.arraycopy(tempr[j], 0, temp, 4 * j, 4 * o++);
            }
            int x = 1;
            System.arraycopy(temp, 0, encoding, i * 16, 16 * x++);
        }
        return encoding;
    }
}
