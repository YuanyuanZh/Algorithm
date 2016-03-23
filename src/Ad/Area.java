package Ad;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Area {
    int id;
    List<HashSet<Content>> timeLine; //每个timeline 最多3个不能重复的content
    public Area(int id) {
        this.id = id;
        timeLine = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
            timeLine.add(i,new HashSet<Content>(3));
    }
}
