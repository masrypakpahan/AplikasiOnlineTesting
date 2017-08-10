package com.pji.cbt.aplikasionlinetesting.network;

        import com.pji.cbt.aplikasionlinetesting.data.respons.QuestionRespon;

        import com.pji.cbt.aplikasionlinetesting.data.respons.ResponTesterUser;

        import com.pji.cbt.aplikasionlinetesting.data.beans.Login_Model;
        import com.pji.cbt.aplikasionlinetesting.data.respons.UpdateUserRespon;
        import com.pji.cbt.aplikasionlinetesting.data.beans.UpdateUser_model;
        import com.pji.cbt.aplikasionlinetesting.data.respons.User;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.PUT;
        import retrofit2.http.Path;

/**
 * Created by Masry Pakpahan on 17/07/2017.
 */

public interface API {
        @POST("/authentication/login")
        Call<User> Login(@Body Login_Model llogin);

        @PUT("/update/profile/{id}")
        Call<UpdateUserRespon> update(@Body UpdateUser_model update);

        @GET("/test/list/{id}")
        Call<ResponTesterUser> getCategoryy(@Path("id") int id);


        @GET("/test/dotest/{idCategory}")
        Call<QuestionRespon> getQuestion(@Path("id") int id);
}

