package in.codingninjas.courses.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by manishakhattar on 11/07/17.
 */

public interface ApiInterface {


    @GET("courses")

    Call<CourseResponse> getCourses();

//    @GET("posts/{post_id}/comments/")
//    @Headers("")
//    @QueryName("a=b")
//    Call<PostResponse> getPost(@Path("post_id") int id, @QueryMap);
//
//
//
//
//    @GET("posts/{post_id}/comments/{comment_id}")
//    Call<PostResponse> getPost(@Path("post_id") int id, @Path("comment_id") int commentId);
////
//    @GET("posts")
//    Call<UserPosts> getUserPosts(@Query("userId") int userId);


//    @GET("users")
//    Call<ArrayList<User>> getUsers();

    /*



    @GET("comments")
    Call<ResponseType> getComments();
     */



}
