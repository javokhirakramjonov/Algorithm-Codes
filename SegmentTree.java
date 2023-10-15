public class SegmentTree {

    private final int n;
    private final int[] segmentTree;

    public SegmentTree(int[] arr) {
        n = arr.length;
        segmentTree = new int[n << 1];

        build(arr, 0, n - 1, 0);
    }

    private void build(int[] arr, int left, int right, int pos) {
        if(left == right) {
            segmentTree[pos] = arr[left];
            return;
        }

        int middle = left + right >> 1;

        build(arr, left, middle, pos << 1 | 1);
        build(arr, middle + 1, right, pos + 1 << 1);

        segmentTree[pos] = Math.min(
                segmentTree[pos << 1 | 1],
                segmentTree[pos + 1 << 1]
        );
    }

    public int minForSubArray(int left, int right) {
        return minForSubArray(0, 0, n - 1, left, right);
    }

    private int minForSubArray(
            int pos,
            int leftOfRange,
            int rightOfRange,
            int left,
            int right
    ) {
//        System.out.println("Entered for range: " + leftOfRange + " " + rightOfRange);

        if(left <= leftOfRange && rightOfRange <= right) {
//            System.out.println("Returning: " + segmentTree[pos] + "\n");
            return segmentTree[pos];
        }

        if(rightOfRange < left || right < leftOfRange) {
//            System.out.println("Returning: " + Integer.MAX_VALUE + "\n");
            return Integer.MAX_VALUE;
        }

        int middleOfRange = leftOfRange + rightOfRange >> 1;

        int minForLeftChild = minForSubArray(
                pos << 1 | 1,
                leftOfRange,
                middleOfRange,
                left,
                right
        );

        int minForRightChild = minForSubArray(
                pos + 1 << 1,
                middleOfRange + 1,
                rightOfRange,
                left,
                right
        );

        int min = Math.min(
                minForLeftChild,
                minForRightChild
        );

//        System.out.println("Returning: " + min + "\n");

        return min;
    }

    public void update(int index, int newValue) {
        update(
                0,
                0,
                n - 1,
                index,
                newValue
        );
    }

    private void update(
            int pos,
            int leftRange,
            int rightRange,
            int index,
            int newValue
    ) {
        if(index <  leftRange || index > rightRange) {
            return;
        }

        if(leftRange == rightRange) {
            segmentTree[pos] = newValue;
            return;
        }

        int middle = leftRange + rightRange >> 1;

        update(
            pos << 1 | 1,
                leftRange,
                middle,
                index,
                newValue
        );

        update(
                pos + 1 << 1,
                middle + 1,
                rightRange,
                index,
                newValue
        );

        segmentTree[pos] = Math.min(
                segmentTree[pos << 1 | 1],
                segmentTree[pos + 1 << 1]
        );
    }

}
