import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { AddVideoComponent } from './add-video/add-video.component';
import { ViewVideoComponent } from './view-video/view-video.component';
import { ViewCategoryComponent } from './view-category/view-category.component';
import { ViewCourseComponent } from './view-course/view-course.component';
import { AdminSidebarComponent } from './admin-sidebar/admin-sidebar.component';
import { EditCategoryComponent } from './edit-category/edit-category.component';
import { EditCourseComponent } from './edit-course/edit-course.component';
import { EditVideoComponent } from './edit-video/edit-video.component';
import { LockedUserNotificationComponent } from './locked-user-notification/locked-user-notification.component';
import { UserLogComponent } from './user-log/user-log.component';
import { ReportsComponent } from './reports/reports.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { BarChartComponent } from './bar-chart/bar-chart.component';
import { CommentChartComponent } from './comment-chart/comment-chart.component';
import { PieChartComponent } from './pie-chart/pie-chart.component';
import { LineChartComponent } from './line-chart/line-chart.component';
import { VideoChartComponent } from './video-chart/video-chart.component';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';

const AdminComponents = [
  AddCategoryComponent,
  AdminDashboardComponent,
  AdminSidebarComponent,
  AddCategoryComponent,
  AddCourseComponent,
  AddVideoComponent,
  EditCategoryComponent,
  EditCourseComponent,
  EditVideoComponent,
  UserLogComponent,
  LockedUserNotificationComponent,
  ReportsComponent,
  ViewUserComponent,
  BarChartComponent,
  CommentChartComponent,
  LineChartComponent,
  PieChartComponent,
  VideoChartComponent,
  DialogBoxComponent
]

@NgModule({
  declarations: [AdminDashboardComponent, AddCategoryComponent, AddCourseComponent, AddVideoComponent, ViewVideoComponent, ViewCategoryComponent, ViewCourseComponent, AdminSidebarComponent, EditCategoryComponent, EditCourseComponent, EditVideoComponent, LockedUserNotificationComponent, UserLogComponent, ReportsComponent, ViewUserComponent, BarChartComponent, CommentChartComponent, PieChartComponent, LineChartComponent, VideoChartComponent, DialogBoxComponent],
  imports: [
    CommonModule,
    AdminComponents
  ],

  exports: [
    AdminComponents
  ]
})
export class AdminModule { }
