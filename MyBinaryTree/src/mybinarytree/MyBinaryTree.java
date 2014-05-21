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

    public MyBinaryTree(Element head) {
        this.head = head;
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

    private void removeElement(String key, Element element) {
        if (element == null) {
            return;
        }
        if (key.compareTo(element.key) > 0) {
            removeElement(key, element.right);
        }
        if (key.compareTo(element.key) < 0) {
            removeElement(key, element.left);
        }
        if (key.compareTo(element.key) == 0) {
            if (element.left == null && element.right == null) {
                element = null;
            }
            if (element.left != null && element.right == null) {
                element = element.left;
            }
            if (element.left == null && element.right != null) {
                element = element.right;
            }
            if (element.left != null && element.right != null) {
                Element temp = element.right;
                Element parent = element.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                element.key = temp.key;
                element.value = temp.value;
                while (parent.left != temp) {
                    parent = parent.left;
                }
                parent.left = temp.right;
                temp = null;
            }
        }
    }

    public void remove(String key) {
        Element temp = this.head;
        if (this.isEmpty()) {
        } else {
            removeElement(key, temp);
        }
    }
}
