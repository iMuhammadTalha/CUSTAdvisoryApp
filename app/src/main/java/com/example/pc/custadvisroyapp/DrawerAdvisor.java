package com.example.pc.custadvisroyapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

public class DrawerAdvisor {

    public static String UserName ="";


    public static void getDrawer(final Activity activity, Toolbar toolbar) {

        PrimaryDrawerItem drawerItemHome = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.home);

        PrimaryDrawerItem drawerItemStudents = new PrimaryDrawerItem().withIdentifier(2).withName("Students").withIcon(R.drawable.students);

        PrimaryDrawerItem drawerItemHeadAdvisorAnnouncments = new PrimaryDrawerItem().withIdentifier(3).withName("Head Advisor Announcments").withIcon(R.drawable.announcments);

        PrimaryDrawerItem drawerItemStudentsAnnouncements = new PrimaryDrawerItem().withIdentifier(4).withName("Students Announcements").withIcon(R.drawable.writing);

        PrimaryDrawerItem drawerItemLogout = new PrimaryDrawerItem().withIdentifier(5).withName("Logout ").withIcon(R.drawable.logout);





               final SharedPreferences pref2 = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
               String userName = pref2.getString(Constants.SESSION_NAME,"Advisor");

               IProfile profile = new ProfileDrawerItem()
                       .withName (userName)

                       .withIcon (R.drawable.custlogo);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity (activity)
                .withHeaderBackground (R.color.colorPrimaryDark)
                .addProfiles(profile)
                .build ();



        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withCloseOnClick(true)
                .withSelectedItem(-1)
                .addDrawerItems(
                        drawerItemHome,
                        drawerItemStudents,
                        drawerItemHeadAdvisorAnnouncments,
                        drawerItemStudentsAnnouncements,
                        drawerItemLogout
                        //new DividerDrawerItem()
                        //drawerItemAbout,
                )
                .withAccountHeader (headerResult)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 1 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, AdvisorHome.class);
                            view.getContext().startActivity(intent);
                        }
                        else if (drawerItem.getIdentifier() == 2 ) {
                            // load schedule screen

                            Intent intent = new Intent(activity, Advisor_AllStudents.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 3 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, AdvisorHeadAdvisorAnnouncements.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 4 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, AdvisorStudentAnnouncements.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 5 ) {
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
