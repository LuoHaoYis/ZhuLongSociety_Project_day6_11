package com.lhy.frams;

import io.reactivex.Observable;

public interface ApiService<P> {


    Observable<P> getDataBean();
}
