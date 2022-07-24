package io.incondensable.review.global.constants;

public class Constants {

    public enum VoteAndCommentStatus {
        NOT_APPROVED((byte) 1, "Not Approved"),
        APPROVED((byte) 2, "Approved");

        private final byte value;
        private final String title;

        VoteAndCommentStatus(byte value, String title) {
            this.value = value;
            this.title = title;
        }

        public byte getValue() {
            return value;
        }

        public String getTitle() {
            return title;
        }
    }

    public enum ProductStatus {
        NOT_REVIEWABLE((byte) 0, "Not Reviewable"),
        REVIEWABLE((byte) 1, "Reviewable");

        private final byte value;
        private final String title;

        ProductStatus(byte value, String title) {
            this.value = value;
            this.title = title;
        }

        public byte getValue() {
            return value;
        }

        public String getTitle() {
            return title;
        }
    }

}
