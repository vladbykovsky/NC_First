import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationBillingAccountComponent } from './registration-billing-account.component';

describe('RegistrationBillingAccountComponent', () => {
  let component: RegistrationBillingAccountComponent;
  let fixture: ComponentFixture<RegistrationBillingAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationBillingAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationBillingAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
