import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Polynomial {

	private Node head; // points to the first Node of a Polynomial

	/**
	 * Default constructor creates a Polynomial with no terms
	 */
	public Polynomial() // DO NOT MODIFY THIS CONSTRUCTOR
	{
		head = null;
	}

	/**
	 * Creates a "deep copy" of a given Polynomial. I.e. a new Polynomial with
	 * identical terms
	 * 
	 * @param p
	 *            Polynomial to be copied
	 */
	@SuppressWarnings("unchecked")
	public Polynomial(Polynomial p) // a "copy" constructor
	{
		if (p != null && p.head != null && p.head.info != null) {
			Node<Term> newNode = new Node<Polynomial.Term>(
					new Term(p.head.info.getCoefficient(), p.head.info.getExponent()));
			newNode.next = null;
			head = newNode;
			Node<Term> temp1 = newNode;
			Node<Term> temp2 = p.head;
			while (temp2.next != null) {
				temp2 = temp2.next;
				newNode = new Node<Polynomial.Term>(new Term(temp2.info.getCoefficient(), temp2.info.getExponent()));
				newNode.next = null;
				temp1.next = newNode;
				temp1 = newNode;
			}
		}
	}

	/**
	 * Creates a new Term and Node containing it and inserts it in its proper
	 * place in this Polynomial (i.e. in ascending order by exponent)
	 * 
	 * @param coeff
	 *            the coefficient of the new Term
	 * @param expo
	 *            the exponent of the new Term
	 */
	@SuppressWarnings("unchecked")
	public void addTerm(int coefficient, int exponent) {
		Term term = new Term(coefficient, exponent);
		Node<Term> first = new Node<Term>(term);
		if (head == null) {
			head = first;
			head.next = null;
		} else {
			Node<Term> node = head;
			Node<Term> lastNode = null;
			while (true) {
				if (node != null) {
					if (node.info.getExponent() <= first.info.getExponent()) {
						lastNode = node;
						node = node.next;
					} else {
						break;
					}
				} else {
					break;
				}
			}

			if (lastNode == null) {
				first.next = head;
				head = first;
			} else {
				Node<Term> temp = lastNode.next;
				lastNode.next = first;
				first.next = temp;
			}
		}
	}

	/**
	 * Returns a polynomial as a String in this form: x + 3x^2 + 7x^3 + x^5
	 * 
	 * @return the polynomial as a String
	 */
	public String toString() {
		Map<Integer, Integer> exponentCoeffMap = new TreeMap<Integer, Integer>();
		Node<Term> temp = head;
		while (temp != null) {
			if (temp.info != null) {
				if (exponentCoeffMap.get(temp.info.getExponent()) == null) {
					exponentCoeffMap.put(temp.info.getExponent(), temp.info.getCoefficient());
				} else {
					exponentCoeffMap.put(temp.info.getExponent(),
							exponentCoeffMap.get(temp.info.getExponent()) + temp.info.getCoefficient());
				}
			}
			temp = temp.next;
		}

		StringBuilder sb = new StringBuilder();
		if (exponentCoeffMap.size() > 0) {
			for (Entry<Integer, Integer> entry : exponentCoeffMap.entrySet()) {
				sb.append(entry.getValue() + "X^" + entry.getKey() + " + ");
			}
		}

		int index = sb.toString().lastIndexOf("+");
		return sb.toString().length() > 0 ? sb.toString().substring(0, index) : "";
	}

	// collect terms of a Polynomial object. I.e. replace all terms having the
	// same exponent with a single term which is their sum
	@SuppressWarnings("unchecked")
	private void collectTerms() {
		Map<Integer, Integer> exponentCoeffMap = new TreeMap<Integer, Integer>();
		Node<Term> temp = head;
		while (temp != null) {
			if (temp.info != null) {
				if (exponentCoeffMap.get(temp.info.getExponent()) == null) {
					exponentCoeffMap.put(temp.info.getExponent(), temp.info.getCoefficient());
				} else {
					exponentCoeffMap.put(temp.info.getExponent(),
							exponentCoeffMap.get(temp.info.getExponent()) + temp.info.getCoefficient());
				}
			}
			temp = temp.next;
		}
		head = null;
		Node<Term> tempNode = null;
		if (exponentCoeffMap.size() > 0) {
			for (Entry<Integer, Integer> entry : exponentCoeffMap.entrySet()) {
				Node<Term> node = new Node<Polynomial.Term>(new Term(entry.getValue(), entry.getKey()));
				node.next = null;
				if (head == null) {
					head = node;
					tempNode = node;
				} else {
					tempNode.next = node;
				}
			}
		}
	}

	/**
	 * Multiply this Polynomial by another Polynomial
	 * 
	 * @param p
	 *            the other Polynomial
	 * @return the Polynomial product
	 */
	public Polynomial polyMultiply(Polynomial p) {
		Map<Integer, Integer> exponentCoeffMap = new TreeMap<Integer, Integer>();
		Node<Term> temp = p.head;
		while (temp != null) {
			if (temp.info != null) {
				if (exponentCoeffMap.get(temp.info.getExponent()) == null) {
					exponentCoeffMap.put(temp.info.getExponent(), temp.info.getCoefficient());
				} else {
					exponentCoeffMap.put(temp.info.getExponent(),
							exponentCoeffMap.get(temp.info.getExponent()) * temp.info.getCoefficient());
				}
			}
			temp = temp.next;
		}

		Map<Integer, Integer> secondExponentCoeffMap = new TreeMap<Integer, Integer>();
		temp = this.head;
		while (temp != null) {
			if (temp.info != null) {
				if (secondExponentCoeffMap.get(temp.info.getExponent()) == null) {
					secondExponentCoeffMap.put(temp.info.getExponent(), temp.info.getCoefficient());
				} else {
					secondExponentCoeffMap.put(temp.info.getExponent(),
							secondExponentCoeffMap.get(temp.info.getExponent()) + temp.info.getCoefficient());
				}
			}
			temp = temp.next;
		}

		Map<Integer, Integer> resultExponentCoeffMap = new TreeMap<Integer, Integer>();
		if (exponentCoeffMap.size() > 0) {
			for (Entry<Integer, Integer> entry : exponentCoeffMap.entrySet()) {
				for (Entry<Integer, Integer> secondEntry : secondExponentCoeffMap.entrySet()) {
					int mulExp = secondEntry.getKey() + entry.getKey();
					int mulCoeff = secondEntry.getValue() * entry.getValue();

					if (resultExponentCoeffMap.get(mulExp) == null) {
						resultExponentCoeffMap.put(mulExp, mulCoeff);
					} else {
						resultExponentCoeffMap.put(mulExp, mulCoeff + resultExponentCoeffMap.get(mulExp));
					}
				}
			}
		}

		Polynomial p1 = new Polynomial();
		Node<Term> newNode = null;
		Node<Term> tempNode = null;
		if (exponentCoeffMap.size() > 0) {
			for (Entry<Integer, Integer> entry : resultExponentCoeffMap.entrySet()) {
				Node<Term> node = new Node<Polynomial.Term>(new Term(entry.getValue(), entry.getKey()));
				node.next = null;
				if (newNode == null) {
					newNode = node;
					tempNode = node;
				} else {
					tempNode.next = node;
					tempNode = node;
				}
			}
		}
		p1.head = newNode;
		return p1;
	}

	/**
	 * Add this Polynomial and another Polynomial
	 * 
	 * @param p
	 *            the other Polynomial
	 * @return the Polynomial sum
	 */
	public Polynomial polyAdd(Polynomial p) {
		Map<Integer, Integer> exponentCoeffMap = new TreeMap<Integer, Integer>();
		Node<Term> temp = p.head;
		while (temp != null) {
			if (temp.info != null) {
				if (exponentCoeffMap.get(temp.info.getExponent()) == null) {
					exponentCoeffMap.put(temp.info.getExponent(), temp.info.getCoefficient());
				} else {
					exponentCoeffMap.put(temp.info.getExponent(),
							exponentCoeffMap.get(temp.info.getExponent()) + temp.info.getCoefficient());
				}
			}
			temp = temp.next;
		}

		temp = this.head;
		while (temp != null) {
			if (temp.info != null) {
				if (exponentCoeffMap.get(temp.info.getExponent()) == null) {
					exponentCoeffMap.put(temp.info.getExponent(), temp.info.getCoefficient());
				} else {
					exponentCoeffMap.put(temp.info.getExponent(),
							exponentCoeffMap.get(temp.info.getExponent()) + temp.info.getCoefficient());
				}
			}
			temp = temp.next;
		}

		Polynomial p1 = new Polynomial();
		Node<Term> newNode = null;
		Node<Term> tempNode = null;
		if (exponentCoeffMap.size() > 0) {
			for (Entry<Integer, Integer> entry : exponentCoeffMap.entrySet()) {
				Node<Term> node = new Node<Polynomial.Term>(new Term(entry.getValue(), entry.getKey()));
				node.next = null;
				if (newNode == null) {
					newNode = node;
					tempNode = newNode;
				} else {
					tempNode.next = node;
					tempNode = node;
				}
			}
		}
		p1.head = newNode;
		return p1;
	}

	// Node class definition - DO NOT MODIFY!
	class Node<E extends Term> {
		private E info; // each node stores an object of the
						// type-parameter class...
		private Node next; // ...and a pointer to another node

		// Node Constructor
		// parameter x is an object of the type-parameter class
		Node(E x) {
			info = x; // set info portion to parameter passed
			next = null; // not necessary, null is default value
		}
	} // end of Node class definition ============================

	class Term {
		private Integer coefficient;
		private Integer exponent;

		public Integer getCoefficient() {
			return coefficient;
		}

		public void setCoefficient(Integer coefficient) {
			this.coefficient = coefficient;
		}

		public Integer getExponent() {
			return exponent;
		}

		public void setExponent(Integer exponent) {
			this.exponent = exponent;
		}

		public Term(Integer coefficient, Integer exponent) {
			super();
			this.coefficient = coefficient;
			this.exponent = exponent;
		}

	}

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial p0 = new Polynomial();

		Polynomial nullTest = p1.polyAdd(p2);
		System.out.println("\np1 = " + p1 + ", np2 = " + p2 + "\tp1 + p2 = " + nullTest);
		nullTest = p1.polyMultiply(p2);
		System.out.println("\np1 = " + p1 + ", np2 = " + p2 + "\tp1 * p2 is " + nullTest);

		p1.addTerm(5, 2);
		p1.addTerm(4, 5);
		p1.addTerm(3, 3);
		p1.addTerm(1, 2);
		p1.addTerm(5, 6);
		p2.addTerm(3, 8);
		p2.addTerm(2, 5);
		p2.addTerm(1, 2);
		p0.addTerm(1, 2);
		p0.addTerm(5, 0);
		p0.addTerm(4, 1);

		System.out.println("\np0 = " + p0);

		Polynomial p3 = p1.polyAdd(p2);
		System.out.println("\np1 = " + p1 + "\np2 = " + p2 + "\np1+p2 = " + p3);

		Polynomial p4 = p1.polyMultiply(p2);
		System.out.println("\np1 = " + p1 + "\np2 = " + p2 + "\np1*p2 = " + p4);

		Polynomial p5 = p2.polyMultiply(p2);
		System.out.println("\np2 = " + p2 + "\np2*p2 = " + p5);

		Polynomial p6 = p0.polyMultiply(p2);
		System.out.println("\np0 = " + p0 + "\n" + "p2 = " + p2 + "\np0*p2 = " + p6);

		Polynomial p7 = p0.polyAdd(p2);
		System.out.println("\np0 = " + p0 + "\n" + "p2 = " + p2 + "\np0+p2 = " + p7);

		p1 = p1.polyAdd(p2);
		System.out.println("\nAfter p1 = p1+p2  p1 = " + p1);

		p2 = p2.polyMultiply(p2);
		System.out.println("\nAfter p2 = p2*p2  p2 = " + p2);

		// Testing copy constructor
		Polynomial pCopy = new Polynomial(p1);
		System.out.println("\nAfter copy p1 =    " + p1);
		System.out.println("After copy pCopy = " + pCopy);
		p1.addTerm(10, 4);
		System.out.println("\nAfter adding 10x^4 to p1, p1 = " + p1);
		System.out.println("But pCopy is still             " + pCopy);

	}
}
