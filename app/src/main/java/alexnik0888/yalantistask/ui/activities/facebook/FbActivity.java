package alexnik0888.yalantistask.ui.activities.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import alexnik0888.yalantistask.R;
import alexnik0888.yalantistask.data.DbManager;
import alexnik0888.yalantistask.model.FBProfile;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Facebook activity class
 */
public class FbActivity extends AppCompatActivity {

    @BindView(R.id.fb_btn) LoginButton mLogBtn;
    @BindView(R.id.fb_name) TextView mName;
    @BindView(R.id.fb_img) ProfilePictureView mPicture;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    private CallbackManager mManager;
    private final String TAG = "FbActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook_activity);
        init();
    }

    private void init(){
        FacebookSdk.sdkInitialize(getApplicationContext());
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(R.string.login);
        }
        mManager = CallbackManager.Factory.create();
        Profile currProfile = Profile.getCurrentProfile();

        if(currProfile != null){
            mPicture.setProfileId(currProfile.getId());
            String name = currProfile.getFirstName()+" "+currProfile.getLastName();
            mName.setText(name);
        }

        mLogBtn.registerCallback(mManager, new FacebookCallback<LoginResult>() {
            private ProfileTracker mProfileTracker;
            @Override
            public void onSuccess(final LoginResult loginResult) {
                if (Profile.getCurrentProfile() == null) {

                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile profile, Profile profile2) {

                            mProfileTracker.stopTracking();

                            mPicture.setProfileId(profile2.getId());

                            String name = profile2.getFirstName() + " " + profile2.getLastName();
                            mName.setText(name);

                            FBProfile fbProfile = new FBProfile();
                            fbProfile.setFirstName(profile2.getFirstName());
                            fbProfile.setLastName(profile2.getLastName());
                            fbProfile.setId(profile2.getId());
                            fbProfile.setLinkUri(String.valueOf(profile2.getLinkUri()));
                            fbProfile.setToken(loginResult.getAccessToken().getToken());

                            new DbManager().writeProfile(fbProfile);
                        }
                    };
                }
            }

            @Override
            public void onCancel() {
                Log.v(TAG, "Canceled");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.e(TAG, exception.toString());
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mManager.onActivityResult(requestCode, resultCode, data);
    }
}
