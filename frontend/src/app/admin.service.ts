import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';

import { environment } from '../environments/environment.prod'
import { Observable, BehaviorSubject } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AdminService {



  len= new BehaviorSubject<any>(0)
  lenupdate=this.len.asObservable()
  userrole: any;
  
  constructor(private http: HttpClient) {
    // this.http.get(environment.baseUserUrl);
  }

  getCategories(): Observable<any> {
    console.log(environment.baseCategoryUrl)
    return this.http.get<any>(environment.baseCategoryUrl);
  }
  
  getCourses(): Observable<any> {
    console.log(environment.baseCourseUrl)
    return this.http.get<any>(environment.baseCourseUrl);
  }
 
  getCategoriesById(id: any): Observable<any>{
    return this.http.get<any>(environment.baseCategoryUrl+"/"+id);
  }

  getCategoriesName(): Observable<any>{
    return this.http.get<any>(environment.baseCategoryUrl+"/category-name");
  }

  getCategoriesCount(): Observable<any> {
    console.log(environment.baseCategoryUrl)
    return this.http.get<any>(environment.baseCategoryUrl+"/total");
  }
  getCourseCount(): Observable<any> {
    console.log(environment.baseCategoryUrl)
    return this.http.get<any>(environment.baseCourseUrl+"/total");
  }
  getUserCount(): Observable<any> {
    console.log(environment.baseAdminUrl)
    return this.http.get<any>(environment.baseAdminUrl+"/usercount");
  }

  addCategory(categoryName: any, categoryDesc: any, categoryLogo:any):Observable<any>{
     console.log(categoryName);   
    return this.http.post<any>(environment.baseCategoryUrl,{categoryName, categoryDesc, categoryLogo})
  }

  editCategory(categoryName: any, categoryDesc: any, categoryLogo:any,categoryId:any):Observable<any>{
    // console.log(category);   
    return this.http.put<any>(environment.baseCategoryUrl+"/"+categoryId,{categoryName, categoryDesc, categoryLogo,categoryId})
  }
  deleteCategory(id: any): Observable<any>{
    return this.http.delete<any>(environment.baseCategoryUrl+"/"+id);
  }

  addCourse(courseName: any, courseDesc: any, courseLogo:any, coursePrice: any, likes: any,
     categoryId: any):Observable<any>{
    // console.log(category);   
    return this.http.post<any>(environment.baseCourseUrl+ "/" +categoryId,{courseName, courseDesc, courseLogo, coursePrice, likes, categoryId  })
  }
  getCourseById(id: any): Observable<any>{
    return this.http.get<any>(environment.baseCourseUrl+"/"+id);
  }

  editCourse(courseId:any,courseName: any, courseDesc: any, courseLogo:any,coursePrice: any,likes: any,categoryId: any):Observable<any>{
    // console.log(category);   
    return this.http.put<any>(environment.baseCourseUrl+"/"+courseId+"/"+categoryId,{courseName, courseDesc, courseId,coursePrice,courseLogo,likes,categoryId})
  }

  deleteCourse(id: any): Observable<any>{
    return this.http.delete<any>(environment.baseCourseUrl+"/"+id);
  }

  getVideos(): Observable<any> {
    console.log(environment.baseVideoUrl)
    return this.http.get<any>(environment.baseVideoUrl);
  }

  getVideoById(id: any): Observable<any>{
    return this.http.get<any>(environment.baseVideoUrl+"/"+id);
  }

  addVideo(videoName: any, videoDesc: any, videoPath:any,courseId:any):Observable<any>{
   // console.log(category);   
   return this.http.post<any>(environment.baseVideoUrl+ "/" +courseId,{videoName, videoDesc, videoPath,courseId  })
 }
 deleteVideo(id: any): Observable<any>{
  return this.http.delete<any>(environment.baseVideoUrl+"/"+id);
}

 editVideo(videoId:any,videoName: any,videoDesc: any,videoPath:any,courseId: any):Observable<any>{
    // console.log(category);   
    return this.http.put<any>(environment.baseVideoUrl+"/"+videoId+"/"+courseId,{videoName,videoDesc,videoId,videoPath,courseId})
  }

  getUsers(): Observable<any> {
    console.log(environment.baseAdminUrl)
    console.log("Inside service");
    
    return this.http.get<any>(environment.baseAdminUrl+"/user");
  }

  unlockUserById(userId:any){
    console.log(userId);
    return this.http.put<any>(environment.baseAdminUrl+"/unlockuser/"+userId, {userId})
  }


  getLockedUsers(): Observable<any>{
    console.log(environment.baseAdminUrl+"/lockedusers");
    return this.http.get<any>(environment.baseAdminUrl+"/lockedusers")
    
    
  }
 
  getCourseState(): Observable<any> {
    return this.http.get<any>(environment.baseCourseReportUrl)
  }

  updateCartSizeData(){
    this.getLockedUsers().subscribe((data1) => {
      this.len.next(data1.length)
    })

  }

  }

