import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoRedesSocialesComponent } from './logo-redes-sociales.component';

describe('LogoRedesSocialesComponent', () => {
  let component: LogoRedesSocialesComponent;
  let fixture: ComponentFixture<LogoRedesSocialesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogoRedesSocialesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LogoRedesSocialesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
