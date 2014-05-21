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
public class Element<E> {
    String key;
    Element left, right;
    E value;
    public Element(String key, E value){
        this.value = value;
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
