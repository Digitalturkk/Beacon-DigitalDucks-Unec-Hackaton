import './department.css';

const filters = [
  { id: 'skill', label: 'All Skills' },
  { id: 'level', label: 'Any Level' },
  { id: 'sort', label: 'Sort: Popular' }
];

const departments = [
  {
    id: 'it',
    title: 'IT',
    subtitle: 'Information Technology',
    tag: 'Popular',
    status: 'Open',
    lessons: '12 lessons',
    level: 'Intermediate',
    gradient: 'card-gradient-purple'
  },
  {
    id: 'data',
    title: 'Data Analitika',
    subtitle: 'Data scientist',
    tag: 'Active',
    status: 'Open',
    lessons: '16 lessons',
    level: 'Advanced',
    gradient: 'card-gradient-cyan'
  },
  {
    id: 'finance',
    title: 'Finance',
    subtitle: 'Documents and data analytics',
    tag: 'New',
    status: 'Open',
    lessons: '10 lessons',
    level: 'Intermediate',
    gradient: 'card-gradient-green'
  },
  {
    id: 'ux1',
    title: 'UX/UI Design',
    subtitle: 'Product & interface design',
    tag: 'New',
    status: 'Open',
    lessons: '12 lessons',
    level: 'Intermediate',
    gradient: 'card-gradient-lime'
  },
  {
    id: 'ux2',
    title: 'UX/UI Design',
    subtitle: 'Product & interface design',
    status: 'Open',
    lessons: '18 lessons',
    level: 'Advanced',
    gradient: 'card-gradient-teal'
  },
  {
    id: 'graphic',
    title: 'Graphic Design',
    subtitle: 'Visual content creation',
    status: 'Locked',
    lessons: '12 lessons',
    level: 'Intermediate',
    gradient: 'card-gradient-blue'
  }
];

const recommended = [
  { id: 'rec1', title: 'UX/UI Design', subtitle: 'Product & interface design', lessons: '12 lessons' },
  { id: 'rec2', title: 'Data Analitika', subtitle: 'Data scientist', lessons: '16 lessons' }
];

export default function Department() {
  return (
    <div className="departments-page">
      <header className="dept-header">
        <div>
          <p className="eyebrow text-muted">Departments</p>
          <h1>Choose a department to start learning</h1>
          <p className="text-muted">Pick a path and gain practical experience.</p>
        </div>
        <div className="search-filters">
          <div className="search-box">
            <input type="text" placeholder="Search department..." />
          </div>
          <div className="filter-group">
            {filters.map((f) => (
              <button key={f.id} type="button" className="filter-chip">
                {f.label}
              </button>
            ))}
          </div>
        </div>
      </header>

      <div className="dept-layout">
        <section className="dept-list">
          <div className="cards-row">
            {departments.map((dept) => (
              <article key={dept.id} className={`dept-card ${dept.gradient}`}>
                <div className="card-top">
                  <span className={`pill ${dept.tag ? 'pill-primary' : 'pill-muted'}`}>
                    {dept.tag || 'Recommended'}
                  </span>
                  <span className={`pill ${dept.status === 'Locked' ? 'pill-lock' : 'pill-success'}`}>
                    {dept.status === 'Locked' ? 'Locked' : 'Open'}
                  </span>
                </div>
                <div className="card-body">
                  <div className="dept-icon">⚡</div>
                  <h3>{dept.title}</h3>
                  <p className="text-muted">{dept.subtitle}</p>
                  <div className="meta">
                    <span>{dept.lessons}</span>
                    <span>{dept.level}</span>
                  </div>
                </div>
                <button
                  type="button"
                  className={`dept-btn ${dept.status === 'Locked' ? 'btn-ghost' : 'btn-primary'}`}
                >
                  {dept.status === 'Locked' ? 'Locked' : 'Open department'}
                </button>
              </article>
            ))}
          </div>
        </section>

        <aside className="dept-aside">
          <div className="aside-card">
            <h4>Recommended for you</h4>
            <div className="recommended-list">
              {recommended.map((item) => (
                <div key={item.id} className="recommended-item">
                  <div className="rec-icon">⚡</div>
                  <div>
                    <p className="rec-title">{item.title}</p>
                    <p className="rec-sub">{item.subtitle}</p>
                    <span className="rec-meta">{item.lessons}</span>
                  </div>
                  <button type="button" className="rec-btn">
                    View
                  </button>
                </div>
              ))}
            </div>
          </div>

          <div className="aside-card promo-card">
            <p className="eyebrow text-muted">Start your learning journey</p>
            <h4>Today!</h4>
            <p className="promo-copy">
              45+ lessons, complete courses, department resources and graduation tasks.
            </p>
            <button type="button" className="dept-btn btn-primary">
              Continue Course
            </button>
          </div>
        </aside>
      </div>
    </div>
  );
}

