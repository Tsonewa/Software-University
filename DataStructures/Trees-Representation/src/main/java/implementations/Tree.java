package implementations;

import interfaces.AbstractTree;

import java.util.ArrayList;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {

    private E key;
    private Tree<E> root;
    private List<Tree<E>> children;


    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public Tree<E> getRoot() {
        return root;
    }

    public void setRoot(Tree<E> root) {
        this.root = root;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<E>> children) {
        this.children = children;
    }

    public Tree(E key, Tree<E>...children) {
       this.key = key;
       this.children = new ArrayList<>();
        for (Tree<E> child: children) {
            this.children.add(child);
            child.root = this;
            this.root = child.root;
        }
    }

    @Override
    public List<E> orderBfs() {

        return null;
    }

    @Override
    public List<E> orderDfs() {

        List<E> result = new ArrayList<>();
        this.dfs(this.root, result);
        return result;
    }

    private void dfs(Tree<E> node, List<E> result) {
        result.add(node.getKey());

        for (Tree<E> child: node.children) {
            dfs(child, result);
        }
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {

    }
	
	@Override
    public void removeNode(E nodeKey) {

    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }
}



