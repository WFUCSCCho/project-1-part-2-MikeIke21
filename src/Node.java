interface binNode<E>{
    public E value();
    public void setValue(E v);

    public binNode<E> left();
    public binNode<E> right();

    public boolean isLeaf();
}

// Implement the constructor
public class Node <E extends Comparable<? super E>> implements binNode<E> {
    E element;
    Node<E> left;
    Node<E> right;

    Node() {
        left = right = null;
    }
    Node(E val){
        if (val == null){
            throw new NullPointerException();
        }
        left = right = null;
        element = val;
    }
    Node(E val, Node<E> l, Node<E> r){
        element = val;
        left = l;
        right = r;
    }


    // Implement the setElement method
    @Override
    public E value() {
        return element;
    }

    public void setValue(E val) {element = val; }


    // Setters and getters: left
    public Node<E> left() {return left;}
    public void setLeft(Node<E> p) {left = p;}

    // setters and getters: right
    public Node<E> right() {return right;}
    public void setRight(Node<E> p) {this.right = p;}


    // Implement the isLeaf method

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    //compareTO





}
