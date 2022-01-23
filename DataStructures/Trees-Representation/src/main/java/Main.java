import implementations.Tree;

public class Main {
    public static void main(String[] args) {

        Tree<Integer> tree =
                new Tree<>(1,
                        new Tree<>(11),
                        new Tree<>(111),
                new Tree<>(2,
                        new Tree<>(3,
                        new Tree<>(4))));

        for (Integer e: tree.orderDfs()) {
            System.out.println(e);
        }

//     printTree(tree);

    }
    //DFS
//    private static void printTree(Tree<Integer> tree) {
//        System.out.println(tree.getKey());
//
//        for (Tree<Integer> node: tree.getChildren()) {
//            printTree(node);
//        }
//
//    }
}
