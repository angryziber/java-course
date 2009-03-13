/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture3;

import java.util.Map;

/**
 *
 * @author Karl
 */
public class Mapdemo {

    public static void main(String[] args) {
		Map<Object, Object> m = System.getProperties();
		for (Map.Entry<Object,Object> e : m.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getKey());
		}
	}
}
