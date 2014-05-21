/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybinarytree;

/**
 *
 * @author Тимур
 * @param <E>
 */
public class MyBinaryTree<E> {

    Element head;

    public MyBinaryTree() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void add(String key, E value) {
        Element temp = this.head;
        if (this.isEmpty()) {
            this.head = new Element(key, value);
        } else {
            this.putElement(key, value, temp);
        }
    }

    private void putElement(String key, E value, Element element) {
        if (key.compareTo(element.key) == 0) {
            element.value = value;
        }
        if (key.compareTo(element.key) > 0) {
            if (element.right != null) {
                this.putElement(key, value, element.right);
            } else {
                element.right = new Element(key, value);
            }
        }
        if (key.compareTo(element.key) < 0) {
            if (element.left != null) {
                this.putElement(key, value, element.left);
            } else {
                element.left = new Element(key, value);
            }
        }
    }

    private Element getElement(String key, Element element) {
        if (key.compareTo(element.key) == 0) {
            return element;
        }
        if (key.compareTo(element.key) > 0) {
            return getElement(key, element.right);
        } else {
            return getElement(key, element.left);
        }
    }
/*готовился с выступлением по функциональному программированию, забыл доделать этот метод
    private void removeElement(String key, Element element) {
        if (key.compareTo(element.left.key) == 0) {
            if (element.left.left == null && element.left.right == null) {
                element.left = null;
            }
            if (element.left.left != null && element.left.right == null) {
                element.left = element.left.left;
            }
            if (element.left.left == null && element.left.right != null) {
                element.left = element.left.right;
            }
            if (element.left.left != null && element.left.right != null) {

            }
        }
    }

    public void remove(String key) {
        Element temp = this.head;
        if (this.isEmpty()) {
            System.out.println("Tree is empty");
        } else {

        }
    }
*/
    public Element get(String key) {
        Element temp = this.head;
        if (this.isEmpty()) {
            return null;
        } else {
            return getElement(key, temp);
        }
    }
}
