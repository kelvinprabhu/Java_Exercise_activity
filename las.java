import java.util.Scanner;

interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem {
    @Override
    public abstract int calculateTrappedWater(int[] blockHeights);
}

class CityBlockConservation extends RainySeasonConservation {
    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length == 0) {
            return 0;
        }

        int n = blockHeights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int waterTrapped = 0;

        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        CityBlockConservation conservation = new CityBlockConservation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of blocks:");
        int n = scanner.nextInt();
        int[] blockHeights = new int[n];
        System.out.println("Enter the heights of the blocks:");
        for (int i = 0; i < n; i++) {
            blockHeights[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Trapped Water: " + conservation.calculateTrappedWater(blockHeights));
    }
}