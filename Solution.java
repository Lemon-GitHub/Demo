package Demo;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        //第一行
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }

        //第二行
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2){
            return result;
        }

        //后续i行情况
        for(int row = 3; row <= numRows; row++){
            List<Integer> prevLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for(int col = 1; col < row - 1; col++){
                curLine.add(prevLine.get(col - 1) + prevLine.get(col));
            }
            result.add(curLine);
            curLine.add(1);
        }
        return result;
    }
}
