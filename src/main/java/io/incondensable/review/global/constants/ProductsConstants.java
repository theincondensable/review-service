package io.incondensable.review.global.constants;

public class ProductsConstants {

    public enum VoteAndCommentStatus {
        NOT_APPROVED((byte) 1),
        APPROVED((byte) 2);

        private final byte value;

        VoteAndCommentStatus(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }
    }

    public enum ProductStatus {
        OBSERVABLE((byte) 0),
        NOT_OBSERVABLE((byte) 1);

        private final byte value;

        ProductStatus(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }
    }

}
