package com.challenge.rangdeapp.factory;

import com.challenge.rangdeapp.model.ParentProfile;
import com.challenge.rangdeapp.model.PersonProfile;
import com.challenge.rangdeapp.model.TutorProfile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jason on 17/01/2017.
 */
public class ProfileFactory {

    public static PersonProfile getProfileWithDefaultNull(String profile,String profilejson) {
        switch (profile) {
            case "Parent":
                ParentProfile parentProfile = new ParentProfile();
                try {

                    JSONObject jsonObject = new JSONObject(profilejson);
                    JSONArray jsonArrayProfile = jsonObject.getJSONArray("profile");
                    JSONObject jsonObjectProfile = jsonArrayProfile.getJSONObject(0);
                    parentProfile.setId(jsonObjectProfile.getString("id"));
                    parentProfile.setName(jsonObjectProfile.getString("name"));
                    parentProfile.setEmail(jsonObjectProfile.getString("email"));

                    return parentProfile;
                   /* JSONObject jsonObject1 = jsonObjectProfile.getJSONObject("profile");

                    parentProfile.setAddress(jsonObject1.getString("address"));
                    parentProfile.setProfilePicURL(jsonObject1.getString("profile_pic_url"));
                    parentProfile.setZipcode(jsonObject1.getString("address"));

                    parentProfile.setStudentName();
                    parentProfile.setStudentSchool();
                    parentProfile.setStudentGrade();
                    parentProfile.setSubjects();*/
                } catch (JSONException e) {
                    return parentProfile;
                }
            case "Tutor":
                TutorProfile tutorProfile = new TutorProfile();
                try {

                    JSONObject jsonObject = new JSONObject(profilejson);
                    JSONArray jsonArrayProfile = jsonObject.getJSONArray("profile");
                    JSONObject jsonObjectProfile = jsonArrayProfile.getJSONObject(0);
                    tutorProfile.setId(jsonObjectProfile.getString("id"));
                    tutorProfile.setName(jsonObjectProfile.getString("name"));
                    tutorProfile.setEmail(jsonObjectProfile.getString("email"));

                    return tutorProfile;
                   /* JSONObject jsonObject1 = jsonObjectProfile.getJSONObject("profile");

                    parentProfile.setAddress(jsonObject1.getString("address"));
                    parentProfile.setProfilePicURL(jsonObject1.getString("profile_pic_url"));
                    parentProfile.setZipcode(jsonObject1.getString("address"));

                    parentProfile.setStudentName();
                    parentProfile.setStudentSchool();
                    parentProfile.setStudentGrade();
                    parentProfile.setSubjects();*/
                } catch (JSONException e) {
                    return tutorProfile;
                }
        }
        return null;
    }
}
