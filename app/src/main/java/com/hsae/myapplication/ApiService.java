package com.hsae.myapplication;

import com.hsae.myapplication.bean.User;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/18
 */
// API 服务接口
public interface ApiService {
    @GET("users")
    Observable<List<User>> getUsers();
}
