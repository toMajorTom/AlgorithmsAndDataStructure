package sort;

public class Test {
	public void BubbleSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	///////////////////////////////////////////////////////
	public void HeapSort(int arr[]) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			adjustHeap(arr, 0, i);
		}
	}

	public void adjustHeap(int[] arr, int s, int e) {
		int temp = arr[s];
		for (int i = 2 * s + 1; i < e; i = 2 * i + 1) {
			if (i + 1 < e && arr[i + 1] > arr[i]) {
				i++;
			}
			if (arr[i] <= temp)
				break;

			swap(arr, i, s);
			s = i;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//////////////////////////////////////////////////
	public void MergeSort(int[] arr, int s, int e) {
		if (s < e) {
			int mid = (s + e) / 2;
			MergeSort(arr, s, mid);
			MergeSort(arr, mid + 1, e);
			merge(arr, s, mid, e);
		}
	}

	private void merge(int[] arr, int s, int mid, int e) {
		int temp[] = new int[arr.length];
		int i = s, j = mid + 1;
		int t = 0;
		while (i <= mid && j <= e) {
			if (arr[i] < arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid)
			temp[t++] = arr[i++];
		while (j <= e)
			temp[t++] = arr[j++];
		t = 0;
		while (s <= e) {
			arr[s++] = temp[t++];
		}
	}

	/////////////////////////////////////////////////
	public void QuickSort(int arr[], int s, int e) {
		if (e < s)
			return;
		int mid = partition(arr, s, e);
		QuickSort(arr, s, mid - 1);
		QuickSort(arr, mid + 1, e);
	}

	private int partition(int arr[], int s, int e) {
		int temp = arr[s];
		while (s < e) {
			while (arr[e] >= temp && s < e) {
				e--;
			}
			arr[s] = arr[e];
			while (arr[s] <= temp && s < e) {
				s++;
			}
			arr[e] = arr[s];
		}
		arr[e] = temp;
		return e;
	}

	//////////////////////////////////////////////////
	public void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		int arr[] = { 23, 23, 1, 2, 3, 43, 12, 32, 6, 44, 0 };
		int arr2[] = { 23, 23, 1, 2, 3, 43, 12, 32, 6, 44, 0 };
		int arr3[] = { 23, 23, 1, 2, 3, 43, 12, 32, 6, 44, 0 };
		int arr4[] = { 23, 23, 1, 2, 3, 43, 12, 32, 6, 44, 0 };
		t.BubbleSort(arr);
		t.print(arr);
		System.out.println();
		
		t.HeapSort(arr2);
		t.print(arr2);
		System.out.println();

		t.MergeSort(arr3, 0, arr3.length - 1);
		t.print(arr3);
		System.out.println();

		t.QuickSort(arr4, 0, arr4.length - 1);
		t.print(arr4);
		System.out.println();
		
	}

}
