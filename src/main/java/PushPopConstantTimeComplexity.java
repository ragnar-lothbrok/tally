import java.util.Stack;

//http://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
public class PushPopConstantTimeComplexity {

	public static void main(String[] args) {

		PushPopConstantTimeComplexity pop = new PushPopConstantTimeComplexity();
		Stack<Integer> stack = new Stack<Integer>();
		Integer minElement = pop.push(stack, 4, null);
		minElement = pop.push(stack, 5, minElement);
		minElement = pop.push(stack, 3, minElement);
		minElement = pop.push(stack, -4, minElement);
		minElement = pop.push(stack, 1, minElement);
		minElement = pop.push(stack, 2, minElement);

		System.out.println(stack + " Min Element : " + minElement);

		minElement = pop.pop(stack, minElement);
		System.out.println("Popping now :>> Min Element : " + minElement);

		minElement = pop.pop(stack, minElement);
		System.out.println("Popping now :>> Min Element : " + minElement);

		minElement = pop.pop(stack, minElement);
		System.out.println("Popping now :>> Min Element : " + minElement);

		minElement = pop.pop(stack, minElement);
		System.out.println("Popping now :>> Min Element : " + minElement);

		minElement = pop.pop(stack, minElement);
		System.out.println("Popping now :>> Min Element : " + minElement);

	}

	public Integer push(Stack<Integer> stack, Integer element, Integer minElement) {
		if (stack.isEmpty()) {
			stack.push(element);
			minElement = element;
		} else {
			if (element > minElement) {
				stack.push(element);
			} else {
				Integer temp = 2 * element - minElement;
				stack.push(temp);
				minElement = element;
			}
		}
		return minElement;
	}

	public Integer pop(Stack<Integer> stack, Integer minElement) {
		if (stack.isEmpty()) {
			return null;
		} else {
			Integer temp = stack.pop();
			if (minElement > temp) {
				temp = 2 * minElement - temp;
				minElement = temp;
			} else {
				return minElement;
			}
		}
		return minElement;
	}

}
