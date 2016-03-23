package Tree;


import java.util.List;

public class findFiles {
    class Node {
        String fileName;
        List<Node> children;
        Node (String name) {
            this.fileName = name;
        }
    }

    public static void findFiles(Node root) {
        helper(root,"");
    }

    public static void helper(Node node, String path) {
        if (node == null) return;
        if (node.children.size() == 0) {
            System.out.println(path+"/"+node.fileName);
            return;
        }
        for (Node n: node.children) {
                helper(n,path +'/'+node.fileName);
        }
    }
}
