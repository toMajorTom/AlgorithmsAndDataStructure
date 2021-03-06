package sort;

public class QuickSort {
	public int partition(int[] arr, int left, int right) {
		int key = arr[left];
		while (left < right) {
			while (arr[right] >= key && left < right) {
				right--;
			}
			arr[left] = arr[right];
			while (arr[left] <= key && left < right) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[right] = key;
		return right;
	}

	public void sort(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		int index = partition(arr, left, right);
		print(arr);
		System.out.println();
		sort(arr, left, index - 1);
		sort(arr, index + 1, right);
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {23,23,1,2,3,43,12,32,6,44,0};
		new QuickSort().sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
