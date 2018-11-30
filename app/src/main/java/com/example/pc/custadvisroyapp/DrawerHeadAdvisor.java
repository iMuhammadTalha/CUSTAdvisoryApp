package com.example.pc.custadvisroyapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class DrawerHeadAdvisor {

    public static String UserNames ="";

    public static void getDrawer(final Activity activity, Toolbar toolbar) {

        PrimaryDrawerItem drawerItemHome = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.home);

        PrimaryDrawerItem drawerItemAnnouncmenets = new PrimaryDrawerItem().withIdentifier(2).withName("Announcmenets").withIcon(R.drawable.writing);

        PrimaryDrawerItem drawerItemStudentsRecords = new PrimaryDrawerItem().withIdentifier(3).withName("Upload Students Records").withIcon(R.drawable.upload);

        PrimaryDrawerItem drawerItemUnApproveAdvisor = new PrimaryDrawerItem().withIdentifier(4).withName("UnApprove Advisor").withIcon(R.drawable.unapprove);
        PrimaryDrawerItem drawerItemAllAdvisors = new PrimaryDrawerItem().withIdentifier(5).withName("Advisors List").withIcon(R.drawable.advisor);
        PrimaryDrawerItem drawerItemCSAdvisors = new PrimaryDrawerItem().withIdentifier(6).withName("CS Advisors").withIcon(R.drawable.advisor);
        PrimaryDrawerItem drawerItemSEAdvisors = new PrimaryDrawerItem().withIdentifier(7).withName("SE Advisors").withIcon(R.drawable.advisor);
        PrimaryDrawerItem drawerItemAllStudents = new PrimaryDrawerItem().withIdentifier(8).withName("Students List").withIcon(R.drawable.students);
        PrimaryDrawerItem drawerItemCSStudents = new PrimaryDrawerItem().withIdentifier(9).withName("CS Students ").withIcon(R.drawable.students);
        PrimaryDrawerItem drawerItemSEStudents = new PrimaryDrawerItem().withIdentifier(10).withName("SE Students ").withIcon(R.drawable.students);
        PrimaryDrawerItem drawerItemLogout = new PrimaryDrawerItem().withIdentifier(11).withName("Logout ").withIcon(R.drawable.logout);





        final SharedPreferences pref = activity.getApplicationContext().getSharedPreferences(Constants.SESSION_PREF, Constants.PRIVATE_MODE);
    //    String userName = pref.getString(Constants.SESSION_NAME,"Head Advisor");

       String userName=UserNames;

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
                        drawerItemAnnouncmenets,
                        drawerItemStudentsRecords,
                    //    new DividerDrawerItem(),
                        drawerItemUnApproveAdvisor,
                        drawerItemAllAdvisors,
                        drawerItemCSAdvisors,
                        drawerItemSEAdvisors,
                        //    new DividerDrawerItem(),
                        drawerItemAllStudents,
                        drawerItemCSStudents,
                        drawerItemSEStudents,
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
                            Intent intent = new Intent(activity, HeadAdvisorHome.class);
                            view.getContext().startActivity(intent);
                        }
                        else if (drawerItem.getIdentifier() == 2 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, HeadAdvisorAnnouncements.class);
                            view.getContext().startActivity(intent);
                        }
                        else if (drawerItem.getIdentifier() == 3 ) {
                            // load schedule screen

                            Intent intent = new Intent(activity, HeadAdvisorUploadStudentsData.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 4 ) {
                            // load schedule screen

                            Intent intent = new Intent(activity, HeadAdvisorUnApproveAdvisors.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 5 ) {
                            // load schedule screen

                            Intent intent = new Intent(activity, HeadAdvisorAllAdvisors.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 6 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, HeadAdvisorCSAdvisors.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 7 ) {
                            // load schedule screen7
                            Intent intent = new Intent(activity, HeadAdvisorSEAdvisors.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 8 ) {
                            // load schedule screen
                            Intent intent = new Intent(activity, HeadAdvisorAllStudents.class);
                            view.getContext().startActivity(intent);
                        }
                        else if (drawerItem.getIdentifier() == 9 ) {
                            // load schedule screen

                            Intent intent = new Intent(activity, HeadAdvisorCSStudents.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 10 ) {
                            // load schedule screen

                            Intent intent = new Intent(activity, HeadAdvisorSEStudents.class);
                            view.getContext().startActivity(intent);

                        }
                        else if (drawerItem.getIdentifier() == 11 ) {
                            // load schedule screen


                            Intent intent = new Intent(activity, HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            view.getContext().startActivity(intent);
                            activity.finish();


                            UserSessionManager.IsLogin="";


                        }
                        return true;
                    }
                })
                .build();
    }

}
