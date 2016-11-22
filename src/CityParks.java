import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CityParks {
	public CityParks() {
		getVals();
	}

	public boolean intersects(Integer[][] arr1, Integer[][] arr2) {
		boolean xBool = ((arr2[0][0] >= arr1[0][0] && arr2[0][0] <= arr1[0][1])
				|| (arr2[0][1] >= arr1[0][0] && arr2[0][1] <= arr1[0][1]))
				|| ((arr1[0][0] >= arr2[0][0] && arr1[0][0] <= arr2[0][1])
						|| (arr1[0][1] >= arr2[0][0] && arr1[0][1] <= arr2[0][1]));
		boolean yBool = ((arr2[1][0] >= arr1[1][0] && arr2[1][0] <= arr1[1][1])
				|| (arr2[1][1] >= arr1[1][0] && arr2[1][1] <= arr1[1][1]))
				|| ((arr1[1][0] >= arr2[1][0] && arr1[1][0] <= arr2[1][1])
						|| (arr1[1][1] >= arr2[1][0] && arr1[1][1] <= arr2[1][1]));
		return xBool && yBool;
	}

	public void getVals() {
		HashMap<Integer, CustomObj> map = new HashMap<Integer, CustomObj>();
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int maxArea = -1;
		for (int i = 0; i < num; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int dx = scan.nextInt();
			int dy = scan.nextInt();

			Integer[][] temp = { { x, x + dx }, { y, y + dy } };
			ArrayList<Integer> found = new ArrayList<Integer>();
			;
			for (Integer k : map.keySet()) {
				ArrayList<Integer[][]> points = map.get(k).points;
				for (Integer[][] objPoints : points) {
					if (intersects(temp, objPoints)) {
						found.add(k);
						break;
					}
				}
			}
			if (found.isEmpty()) {
				map.put(i, new CustomObj(temp));
				if(map.get(i).area>maxArea)
					maxArea = map.get(i).area;
			} else {
				if (found.size() > 1) {
					map.get(found.get(0)).points.add(temp);
					map.get(found.get(0)).area += ((temp[0][1]-temp[0][0])*(temp[1][1]-temp[1][0]));
					for (int j = 1; j < found.size(); j++) {
						CustomObj tempObj = merge(map.get(found.get(0)),map.get(found.get(j)));
						map.remove(found.get(j));
						map.put(found.get(0), tempObj);
					}
					if(map.get(found.get(0)).area>maxArea)
						maxArea = map.get(found.get(0)).area;
				}
				else{
					CustomObj tempObj = map.get(found.get(0));
					tempObj.points.add(temp);
					tempObj.area+=((temp[0][1]-temp[0][0])*(temp[1][1]-temp[1][0]));
					if(tempObj.area>maxArea)
						maxArea = tempObj.area;
					map.put(found.get(0), tempObj);
				}

			}
			//System.out.println("3");
		}
		System.out.println(maxArea);
	}

	public class CustomObj {
		int area;
		ArrayList<Integer[][]> points = new ArrayList<Integer[][]>();

		public CustomObj(Integer[][] array) {
			area = (array[0][1] - array[0][0]) * (array[1][1] - array[1][0]);
			points.add(array);
		}
	}

	public CustomObj merge(CustomObj obj1, CustomObj obj2) {
		obj1.area += obj2.area;
		int temp = obj2.points.size();
		for (int i = 0; i < temp; i++) {
			obj1.points.add(obj2.points.get(i));
		}
		return obj1;
	}

	public static void main(String[] args) {
		CityParks app = new CityParks();
	}
}
