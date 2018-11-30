package com.example.pc.custadvisroyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.SharedPreferences;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class DrawerStudent {

    public static String UserName ="";


    public static void getDrawer(final Activity activity, Toolbar toolbar) {

        PrimaryDrawerItem drawerItemHome = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.home);

        PrimaryDrawerItem drawerItemAdvisor = new PrimaryDrawerItem().withIdentifier(2).withName("Advisor").withIcon(R.drawable.advisor);

        PrimaryDrawerItem drawerItemAnnouncements = new PrimaryDrawerItem().withIdentifier(3).withName("Announcements").withIcon(R.drawable.announcments);

        PrimaryDrawerItem drawerItemLogout = new PrimaryDrawerItem().withIdentifier(4).withName("Logout ").withIcon(R.drawable.logout);





               final SharedPreferences pref3 = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
               String userName = pref3.getString(Constants.SESSION_NAME,"Student");

               IProfile profile = new ProfileDrawerItem()
                       .withName (userName)
                       .withIcon (R.drawable.custlogo);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity (activity)
                .withHeaderBackground (R.color.colorPrimaryDark)
                               .addProfiles(profile)
                .build ();



        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withCloseOnClick(true)
                .withSelectedItem(-1)
                .addDrawerItems(
                        drawerItemHome,
                        drawerItemAdvisor,
                        drawerItemAnnouncements,
                        drawerItemLogout

                )
                .withAccountHeader (headerResult)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 1 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, StudentHome.class);
                            view.getContext().startActivity(intent);
                        }
                        else if (drawerItem.getIdentifier() == 2 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, StudentAdvisor.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 3 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, StudentAnnouncements.class);
                            view.getContext().startActivity(intent);

                        }

                        else if (drawerItem.getIdentifier() == 4 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            view.getContext().startActivity(intent);

                            UserSessionManager.IsLogin="";
                        }

                        return true;
                    }
                })
                .build();
    }

}
