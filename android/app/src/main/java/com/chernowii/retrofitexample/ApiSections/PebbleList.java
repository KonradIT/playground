package com.chernowii.retrofitexample.ApiSections;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PebbleList {
    @SerializedName("data")
    public List<PebbleApp> data = new ArrayList();

}
