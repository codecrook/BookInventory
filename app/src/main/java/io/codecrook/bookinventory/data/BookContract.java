package io.codecrook.bookinventory.data;

import android.provider.BaseColumns;

public final class BookContract {
    private BookContract() {}

    public static final class BookEntry implements BaseColumns {
        public final static String TABLE_NAME = "books";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME = "product_name";
        public final static String COLUMN_PRODUCT_PRICE = "product_price";
        public final static String COLUMN_PRODUCT_QUANTITY = "product_quantity";
        public final static String COLUMN_PRODUCT_SUPPLIER_NAME = "product_supplier_name";
        public final static String COLUMN_PRODUCT_SUPPLIER_PHONE_NO = "product_supplier_ph_no";
    }
}
