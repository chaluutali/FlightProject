import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import {ScheduledFlightService} from '../../services/scheduled-flight.service';
import {Mail} from './mail';

@Component({
  selector: 'app-fanmail',
  templateUrl: './fanmail.component.html',
  styleUrls: ['./fanmail.component.css']
})
export class FanmailComponent implements OnInit {

  messageReply: string;
  extendedMessage: Mail;
  importantMessages = [];
  deletedMessages = [];
  preservedMessages = [];
  messages = [];
  user = [];
  currentView: string;

  showInbox: boolean = true;
  showComposer: boolean = false;
  showExtendedView: boolean= false;


  receiver: string;
  subject: string;
  message: string;
  attachment = null;
  isDeleted: boolean = false;
  isStarred: boolean = false;
  isViewed: boolean = false;
  starred: boolean = false;

  inboxCounter: number = 0;


  showAlternate: boolean = false;
  showOriginal: boolean = true;
  constructor(private _router: Router, private scheduledFlightService: ScheduledFlightService) { }

  ngOnInit() {

    this.currentView = "Inbox";
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.user);



    this.scheduledFlightService.getAllMail().subscribe((res)=>{

      this.messages = res;
      var i;
      for (i = 0; i < this.messages.length; i++)
      {
        if(res[i].viewed === false){

          this.inboxCounter = this.inboxCounter + 1;
        }
      }

      console.log(this.messages);



    });



  }
  back(){

  var _currentUser =  JSON.parse(localStorage.getItem('currentUser'));
    this._router.navigate(['profile/'+ _currentUser.emailAddress]);

  }
  compose(){
this.currentView = "Compose"
this.showInbox = false;
this.showComposer = true;
this.showExtendedView = false;

  }
  viewInbox(){
    this.scheduledFlightService.getAllMail().subscribe((res)=>{

      this.messages = res;
      this.currentView = "Inbox";
      this.showInbox = true;
      this.showComposer = false;
      this.showExtendedView = false;
      this.inboxCounter = 0;
      var i;
      for (i = 0; i < this.messages.length; i++)
      {
        if(res[i].viewed === false){

          this.inboxCounter = this.inboxCounter + 1;
        }

      }

    });



  }
  viewSentMail(){

    this.scheduledFlightService.getAllMailSent().subscribe((res)=>{

      this.messages = res;
      this.currentView = "Sent Mail";
      this.showInbox = true;
      this.showComposer = false;
      this.showExtendedView = false;
    });

  }
  viewImportantMail(){

    this.scheduledFlightService.getAllMails().subscribe((res)=>{

      var i;
      for (i = 0; i < res.length; i++)
      {
        if(res[i].starred === true){

          this.importantMessages.push(res[i]);
        }
      }
      this.messages = this.importantMessages;
      this.currentView = "Important Mail";
      this.showInbox = true;
      this.showComposer = false;
      this.showExtendedView = false;
      this.importantMessages = [];

    });
  }

  viewTrash(){


        this.scheduledFlightService.getAllMails().subscribe((res)=>{

          var i;
          for (i = 0; i < res.length; i++)
          {
            if(res[i].deleted === true){
              res[i].deleted = false;
              this.deletedMessages.push(res[i]);
            }
          }
          this.messages = this.deletedMessages;
          this.preservedMessages = this.deletedMessages;
          this.currentView = "Trash";
          this.showInbox = true;
          this.showComposer = false;
          this.showExtendedView = false;
          this.deletedMessages = [];

        });



  }
  viewExtendedMessage(i){
  this.extendedMessage = this.messages[i]

  var i;
  for (i = 0; i < this.preservedMessages.length; i++)
  {

    if (this.extendedMessage.fanmailId === this.preservedMessages[i].fanmailId)
    {
      this.showAlternate = true;
      this.showOriginal = false;
      

    }
  }
    this.showExtendedView = true;
    this.showInbox = false;
    this.showComposer = false;

    this.extendedMessage.viewed = true;

    console.log(this.extendedMessage);
    this.scheduledFlightService.updateMail(this.extendedMessage).subscribe((res)=>{



    });

  }

onReply(){

  var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
  this.showExtendedView = false;
  this.showInbox = false;
  this.showComposer = true;


  this.extendedMessage.viewed = false;
  this.extendedMessage.receiver = this.extendedMessage.sender;
  this.receiver = this.extendedMessage.sender;
  this.subject = this.extendedMessage.subject;






}

moveToTrash(){

  this.showExtendedView = false;
  this.showInbox = false;
  this.showComposer = false;
  this.extendedMessage.deleted = true;

  console.log(this.extendedMessage);
  this.scheduledFlightService.updateMail(this.extendedMessage).subscribe((res)=>{



  });





}
deleteMail(){
    const  fanmail = {

      fanmailId: this.extendedMessage.fanmailId

    }
    this.scheduledFlightService.deleteMail(fanmail).subscribe((res)=>{

        this.viewInbox();
    });



}
markAsImportant(i){

  this.showExtendedView = false;
  this.showInbox = true;
  this.showComposer = false;
  this.extendedMessage.starred = true;

  console.log(this.extendedMessage);
  this.scheduledFlightService.updateMail(this.extendedMessage).subscribe((res)=>{



  });






}
  onSend(){

    var _currentUser = JSON.parse(localStorage.getItem('currentUser'));
    const  fanmail = {

      receiver: this.receiver,
      sender: _currentUser.emailAddress,
      subject: this.subject,
      message: this.message,
      attachment: this.attachment,
      time: Date.now(),
      isDeleted: this.isDeleted,
      isStarred: this.isStarred,
      isViewed: this.isViewed


    }
    this.scheduledFlightService.sendMail(fanmail).subscribe((res)=>{

      this.receiver = '';
      this.subject = '';
      this.message = '';
      this.attachment = null;
      this.isDeleted = false;
      this.isStarred = false;
      this.isViewed = false;
      this.viewInbox();

    });




  }

}
