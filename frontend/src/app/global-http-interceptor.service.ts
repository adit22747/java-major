import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, retry } from 'rxjs/operators';
export class GlobalHttpInterceptorService implements HttpInterceptor {
  constructor() { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    return next.handle(request).pipe(
      map((event: HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            
              console.log('event--->>>', event);
          }
          return event;
      }),
      catchError((error: HttpErrorResponse) => {
        console.log('working here...')
          let data = {};
          data = {
              reason: error && error.error && error.error.reason ? error.error.reason : '',
              status: error.status,
              msg:error.message
          };
          //alert(error.error.message);
          return throwError(error.error.message);
      }));
  }
  // intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  //   return next.handle(request).pipe(
  //     retry(3),
  //     catchError(err => {
  //     const error = err.error.message || err.statusText;
  //     alert('http error: '+ err.error.status + error)
  //     return throwError(error);
  //   }))
  // }
}



