package com.hsae.myapplication.ui.News;

import android.util.Log;

import com.hsae.myapplication.model.ApiService;
import com.hsae.myapplication.model.RetrofitClient;
import com.hsae.myapplication.model.bean.NewsItem;
import com.hsae.myapplication.model.bean.User;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 常见的 Observable 创建方法
 * 方法	描述
 * just()	发射一组固定的值
 * fromCallable()	从 Callable 中获取一个值并发射
 * create()	使用自定义的发射逻辑
 * fromIterable()	从集合或数组中发射数据
 * range()	发射一系列的整数
 * interval()	每隔指定时间发射递增的数字
 * timer()	延迟指定时间后发射一个项（通常是 0）
 * empty()	不发射数据，直接 onComplete()
 * never()	不发射数据，也不会结束
 */
public class UsersViewModel extends ViewModel {
    private final MutableLiveData<List<NewsItem>> newsList = new MutableLiveData<>();
    private final MutableLiveData<List<User>> usersList = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();

    public LiveData<List<NewsItem>> getNewsList() {
        return newsList;
    }

    public LiveData<List<User>> getUsersList() {
        return usersList;
    }

    public void fetchNews() {
        disposables.add(
                getNewsFromNetwork() // 模拟网络请求
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(newsList::setValue, Throwable::printStackTrace, new Action() {
                            @Override
                            public void run() throws Throwable {
                                Log.i("qiansheng", "onComplete");
                            }
                        })
        );
    }

    private Observable<List<NewsItem>> getNewsFromNetwork() {
        return Observable.create(new ObservableOnSubscribe<List<NewsItem>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<NewsItem>> emitter) throws Throwable {
                List<NewsItem> list = new ArrayList<>();
                list.add(new NewsItem("hhhhhhhhhhhhhhhhhhh"));;
                list.add(new NewsItem("wwwwwwwwwwwwwwwwwwwww"));
                list.add(new NewsItem("fffffffffffffffffffff"));
                emitter.onNext(list);
                emitter.onComplete();
            }
        }).delay(2, java.util.concurrent.TimeUnit.SECONDS);
        // 模拟网络延迟并返回数据
//        return Observable.fromCallable(() ->
//                Arrays.asList(
//                        new NewsItem("News Title 1"),
//                        new NewsItem("News Title 2"),
//                        new NewsItem("News Title 3")
//                )).delay(2, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void getUsers(){
        ApiService apiService = RetrofitClient.getApiService();
        apiService.getUsers()
                .subscribeOn(Schedulers.io()) // 在 I/O 线程上执行请求
                .observeOn(AndroidSchedulers.mainThread()) // 在主线程上观察结果
                .subscribe(
                        users -> { // 成功回调
                            List<User> users1 = new ArrayList<>();
                            for (User user : users) {
                                Log.i("qiansheng", user.toString());
                                users1.add(user);
                            }
                            usersList.setValue(users1);
                        },
                        throwable -> { // 错误回调
                            Log.e("qiansheng", "Error fetching users", throwable);
                            if (throwable instanceof SocketTimeoutException) {
                                //超时异常
                                Log.i("qiansheng", "SocketTimeoutException");
                            } else if (throwable instanceof ConnectException) {
                                Log.i("qiansheng", "ConnectException");
                            } else if (throwable instanceof UnknownHostException) {
                                //无网络
                                Log.i("qiansheng", "UnknownHostException");
                            }
                        }
                );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear(); // 清理 RxJava 订阅，防止内存泄漏
    }
}

